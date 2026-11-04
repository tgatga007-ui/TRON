# Architecture (proposal)

This document describes intended boundaries. It does not describe implemented wallet functionality.

## Components

1. **Android presentation** — displays portfolio and transaction state only after the underlying data and security model are implemented and reviewed. UI must clearly identify network, asset, destination, amount, and fees before user confirmation.
2. **Application/domain layer** — chain-neutral account and transaction workflows; validates user intent and enforces explicit confirmation. It must not implement cryptographic primitives.
3. **Chain adapters** — separate modules/interfaces for TRON, Ethereum, Bitcoin, and Solana. Each adapter owns network-specific address validation, transaction serialization, fee handling, and confirmation/finality interpretation. Never assume that similar-looking addresses or transaction formats are interchangeable.
4. **Key boundary** — a narrowly scoped signing interface, isolated from UI and network code. The eventual key-management design must document recovery, backup, device migration, lockout, and supported curves before implementation. No cloud service should receive seed phrases or signing keys.
5. **Remote infrastructure (optional)** — public blockchain reads, price data, and monitoring only. Treat RPC responses as untrusted; do not make a remote provider the authority for user consent or private-key custody.

## Cryptographic and protocol constraints

Use established, audited implementations and the standards of each network; do not invent cryptography or a shared derivation scheme. The ecosystems have different signing and transaction requirements: Bitcoin and common TRON/Ethereum account flows use secp256k1-based signatures; Ethereum transaction formats and typed-data signing have their own rules; Solana commonly uses Ed25519. Bitcoin also has script- and spending-path-specific requirements, including Schnorr for Taproot. These examples are not a complete implementation specification.

Before selecting libraries or implementing derivation, specify supported networks and address/script types, derivation paths, import/export behavior, signature formats, transaction versions, and recovery interoperability. Verify against official specifications and published test vectors for every supported case. Do not silently coerce keys or transactions between curves or networks.

## Trust and transaction flow (future design)

- Display the selected network and account explicitly; reject mismatches.
- Fetch untrusted transaction data, decode it locally, and show a human-readable summary including destination, amount, network, and fees.
- Require explicit user confirmation of the exact reviewed transaction.
- Sign only through the isolated key boundary, then verify the serialized transaction and broadcast it through a chain adapter.
- Show a pending state until chain-appropriate confirmation/finality is established. Handle provider disagreement, reorgs, and failed or replaced transactions.

This is a design outline, not implemented behavior. Do not enable signing or broadcasting until the threat model, transaction review UX, test coverage, and independent audit are complete.

## Suggested module evolution

Keep the current placeholder app inert. As work is approved, introduce separately testable modules such as `core/domain`, `core/security`, `chain/tron`, `chain/ethereum`, `chain/bitcoin`, and `chain/solana`. Pin and audit dependencies, record licenses and provenance, and add each chain only after its requirements and test vectors are reviewed.
