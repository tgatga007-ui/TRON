# TRON — multi-chain Android wallet (project scaffold)

> **Status: documentation and UI scaffold only.** This repository does not yet create wallets, manage keys, connect to blockchain networks, sign transactions, or transfer assets. Do not send funds or enter a recovery phrase based on this project.

The planned product is a native Android, self-custody wallet for **TRON (TRX), Ethereum (ETH), Bitcoin (BTC), and Solana (SOL)**. The repository is unified: Android app, chain integration boundaries, security requirements, and implementation roadmap belong here.

## Project layout

- `app/` — minimal Android application shell; intentionally has no wallet or network functionality.
- `docs/ARCHITECTURE.md` — proposed component boundaries and chain-specific considerations.
- `docs/CRYPTO_SECURITY_ROADMAP.md` — staged requirements and verification gates; not a claim of implemented security.
- `SECURITY.md` — safe-development and vulnerability-reporting guidance.

## Build the placeholder app

Open this repository in Android Studio with Android SDK 35 installed, or build with Gradle 8.9 and a Java 17 JDK:

```sh
gradle assembleDebug
```

This builds only the informational placeholder screen. It is not a wallet and contains no blockchain SDKs, signing code, or wallet secrets.

## Safety

Never commit or share private keys, seed phrases, wallet backups, or signing secrets. Do not use this repository to handle real funds. Any future wallet implementation must pass independent security review, chain-specific test vectors, and release-readiness checks before use with real assets.

## Ownership and license

The MIT license applies to this repository's software; it does not establish ownership of a blockchain, wallet address, token, NFT, or other digital asset. Technical control and legal ownership are distinct and depend on context and applicable law.

## Documentación en español

Este repositorio es una **base de documentación y una pantalla de ejemplo**, no una wallet funcional: todavía no crea wallets, gestiona claves, se conecta a redes, firma transacciones ni transfiere activos. El producto propuesto es una wallet Android autocustodiada para **TRON (TRX), Ethereum (ETH), Bitcoin (BTC) y Solana (SOL)**. No envíes fondos ni introduzcas una frase de recuperación basándote en este proyecto. Consulta la [arquitectura](docs/ARCHITECTURE.md), la [hoja de ruta de seguridad](docs/CRYPTO_SECURITY_ROADMAP.md) y [SECURITY.md). Nunca publiques claves privadas, frases semilla ni secretos de firma.
