# Crypto security roadmap / Hoja de ruta de seguridad cripto

**Status / Estado: requirements only — not implemented / solo requisitos; no implementados.**

This document records ten focused improvements required before this repository can responsibly be described as a real Android self-custody wallet. It is not a security audit or a claim that the features exist. The repository currently has no wallet application code.

Este documento registra diez mejoras especializadas que se requieren antes de describir responsablemente este repositorio como una wallet Android real de autocustodia. No es una auditoría de seguridad ni afirma que las funciones existan. Actualmente el repositorio no contiene código de una aplicación de wallet.

## Ten improvements / Diez mejoras

1. **On-device key generation / Generación local de claves** — Generate secrets only on the user's device with a cryptographically secure random source. Never generate or retain a user's keys on a project server. / Generar secretos únicamente en el dispositivo del usuario con una fuente criptográfica segura. Nunca generar ni conservar claves del usuario en un servidor del proyecto.

2. **Protected local secret storage / Protección local de secretos** — Design encrypted local storage using Android security facilities, with explicit threat analysis for backups, device compromise, screenshots, memory, and app data. Do not claim that Android Keystore makes every wallet secret non-exportable; the design must be validated for each key type. / Diseñar almacenamiento local cifrado usando las capacidades de seguridad de Android y analizar copias de seguridad, dispositivos comprometidos, capturas, memoria y datos de la app. No afirmar que Android Keystore hace que todo secreto sea imposible de exportar; validar el diseño para cada tipo de clave.

3. **No secret telemetry or logging / Sin telemetría ni registros de secretos** — Exclude seed phrases, private keys, passwords, signed payloads, and sensitive account metadata from logs, analytics, crash reports, and clipboard flows. / Excluir frases semilla, claves privadas, contraseñas, cargas firmadas y metadatos sensibles de registros, analítica, informes de fallos y flujos del portapapeles.

4. **Strict chain and address validation / Validación estricta de red y dirección** — Keep BTC, LTC, ETH, TRON, and SOL network identities distinct; validate address encoding/checksums and show the selected network before receive or send actions. / Mantener diferenciadas las redes BTC, LTC, ETH, TRON y SOL; validar formatos y sumas de comprobación, y mostrar la red seleccionada antes de recibir o enviar.

5. **Transaction review before signing / Revisión antes de firmar** — Present the destination, asset, amount, network, fee, and decoded contract operation in a human-readable confirmation screen. Reject unsupported or ambiguous payloads rather than blind-signing them. / Mostrar destino, activo, cantidad, red, comisión y operación de contrato interpretada en una confirmación legible. Rechazar cargas no compatibles o ambiguas en vez de firmarlas a ciegas.

6. **Network-specific transaction rules / Reglas de transacción por red** — Implement and test each chain's transaction model separately, including Bitcoin/Litecoin UTXO selection and fee handling, EVM chain IDs and nonce handling, TRON resource/fee behavior, and Solana recent blockhash and account requirements. / Implementar y probar por separado el modelo de cada red, incluidos selección UTXO y comisiones de Bitcoin/Litecoin, identificadores de cadena y nonces EVM, recursos/comisiones de TRON y blockhash reciente y requisitos de cuentas de Solana.

7. **Safe RPC and provider boundaries / Límites seguros para RPC y proveedores** — Use configurable, authenticated HTTPS endpoints where supported; never send signing secrets to RPC providers. Minimize address leakage, document third-party providers, and handle unreliable or malicious responses defensively. / Usar endpoints HTTPS configurables y autenticados cuando sea posible; nunca enviar secretos de firma a proveedores RPC. Minimizar la exposición de direcciones, documentar proveedores externos y manejar respuestas poco fiables o maliciosas de forma defensiva.

8. **Recovery and backup safeguards / Protección de recuperación y copias** — Provide accurate, chain-compatible recovery instructions, clear warnings against sharing a seed, and a tested restore flow. Do not upload backups to project infrastructure. / Proporcionar instrucciones de recuperación precisas y compatibles con cada cadena, advertir claramente que no se comparta la frase semilla y probar la restauración. No subir copias a la infraestructura del proyecto.

9. **Testnet-first and failure testing / Primero redes de prueba y pruebas de fallos** — Keep testnet and mainnet clearly separated; test malformed addresses, fee spikes, network outages, replay/wrong-chain risks, interrupted signing, and recovery before mainnet use. / Mantener claramente separadas las redes de prueba y producción; probar direcciones malformadas, aumentos de comisiones, caídas de red, riesgos de repetición o red equivocada, interrupciones de firma y recuperación antes de usar la red principal.

10. **Reproducible releases and independent review / Versiones reproducibles y revisión independiente** — Add automated tests, dependency and supply-chain review, reproducible release practices, a vulnerability-reporting process, and an independent security audit before claiming production readiness. Publish limitations and unresolved findings. / Añadir pruebas automatizadas, revisión de dependencias y cadena de suministro, prácticas de publicación reproducibles, un proceso para reportar vulnerabilidades y una auditoría de seguridad independiente antes de afirmar que está listo para producción. Publicar limitaciones y hallazgos pendientes.

## Release gate / Condición de publicación

A feature is not complete because it is listed here. Mark a requirement implemented only after code, tests, and review demonstrate it. Never claim that a wallet is private, secure, audited, or ready for real funds without evidence supporting that exact claim.

Una función no está implementada por aparecer en esta lista. Marcar un requisito como implementado solo después de que el código, las pruebas y la revisión lo demuestren. Nunca afirmar que una wallet es privada, segura, auditada o apta para fondos reales sin pruebas que respalden exactamente esa afirmación.
