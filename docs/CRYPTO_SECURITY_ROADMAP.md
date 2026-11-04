# Crypto security roadmap

This roadmap records requirements, not implemented protections. The repository currently has no wallet, key-management implementation, transaction signer, or blockchain transfer feature.

## Stage 0 — scope and threat model

- Define supported networks, mainnet/testnet behavior, address and transaction types, custody model, recovery UX, supported Android versions, and explicit out-of-scope features.
- Model device compromise, malicious apps, UI spoofing, supply-chain compromise, RPC manipulation, clipboard/screenshot leakage, backup exposure, and user error.
- Define security ownership, dependency review, release signing, incident response, and an independent audit plan.

## Stage 1 — architecture and dependencies

- Keep presentation, domain logic, chain adapters, and signing boundaries separate.
- Select maintained, independently reviewed libraries per chain; document versions, licenses, provenance, known advisories, and upgrade policy.
- Use official protocol specifications and published test vectors. No custom cryptography, undocumented key formats, or silent network/curve conversion.
- Establish automated tests, static analysis, secret scanning, reproducible build goals, and dependency/SBOM review.

## Stage 2 — key and recovery design (not implemented)

- Document how keys are generated, encrypted at rest, unlocked, backed up, recovered, and deleted. Minimize plaintext lifetime and prevent secrets from entering logs, analytics, crash reports, clipboard, or ordinary cloud backups.
- Evaluate Android Keystore capabilities and limitations for each required curve and recovery workflow; do not assume hardware-backed storage supports every chain's signing primitive.
- Define entropy, mnemonic, derivation, passphrase, and import/export behavior per supported standard and validate with interoperability vectors.
- Never upload seed phrases or private keys to a server. Security properties and backup limitations must be explained to users.

## Stage 3 — one chain at a time

For each of TRON, Ethereum, Bitcoin, and Solana, separately specify network identification, address formats, derivation paths, transaction encoding, signature rules, fee estimation, confirmation/finality, provider failure handling, and recovery interoperability. Add test vectors and negative tests before enabling any user-facing operation. Test only with official test networks and valueless assets during development.

## Stage 4 — transaction safety

- Decode the exact transaction locally and show network, destination, asset, amount, fees, and consequential contract/program data before signing.
- Bind the user's confirmation to the exact transaction bytes reviewed; reject stale, altered, ambiguous, or wrong-network requests.
- Test malformed inputs, replay/mismatch scenarios, fee extremes, provider inconsistency, chain reorganizations, and transaction replacement/failure cases.

## Stage 5 — release gate

No real-funds release until independent security review, remediation of critical/high findings, chain-specific interoperability testing, recovery drills, privacy review, signed release pipeline, and a documented incident-response process are complete. A passing build or test suite alone is not an audit.
