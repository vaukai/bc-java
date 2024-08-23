package org.bouncycastle.pqc.jcajce.provider;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMKeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public class MLKEM
{
    private static final String PREFIX = "org.bouncycastle.pqc.jcajce.provider" + ".mlkem.";

    public static class Mappings
            extends AsymmetricAlgorithmProvider
    {
        public Mappings()
        {
        }

        public void configure(ConfigurableProvider provider)
        {
            provider.addAlgorithm("KeyFactory.ML-KEM", PREFIX + "MLKEMKeyFactorySpi");

            addKeyFactoryAlgorithm(provider, "ML-KEM-512", PREFIX + "MLKEMKeyFactorySpi$MLKEM512", NISTObjectIdentifiers.id_alg_ml_kem_512, new MLKEMKeyFactorySpi.MLKEM512());
            addKeyFactoryAlgorithm(provider, "ML-KEM-768", PREFIX + "MLKEMKeyFactorySpi$MLKEM768", NISTObjectIdentifiers.id_alg_ml_kem_768, new MLKEMKeyFactorySpi.MLKEM768());
            addKeyFactoryAlgorithm(provider, "ML-KEM-1024", PREFIX + "MLKEMKeyFactorySpi$MLKEM1024", NISTObjectIdentifiers.id_alg_ml_kem_1024, new MLKEMKeyFactorySpi.MLKEM1024());


            provider.addAlgorithm("KeyPairGenerator.ML-KEM", PREFIX + "MLKEMKeyPairGeneratorSpi");

            addKeyPairGeneratorAlgorithm(provider, "ML-KEM-512", PREFIX + "MLKEMKeyPairGeneratorSpi$MLKEM512", NISTObjectIdentifiers.id_alg_ml_kem_512);
            addKeyPairGeneratorAlgorithm(provider, "ML-KEM-768", PREFIX + "MLKEMKeyPairGeneratorSpi$MLKEM768", NISTObjectIdentifiers.id_alg_ml_kem_768);
            addKeyPairGeneratorAlgorithm(provider, "ML-KEM-1024", PREFIX + "MLKEMKeyPairGeneratorSpi$MLKEM1024", NISTObjectIdentifiers.id_alg_ml_kem_1024);

            provider.addAlgorithm("KeyGenerator.ML-KEM", PREFIX + "MLKEMKeyGeneratorSpi");

            addKeyGeneratorAlgorithm(provider, "ML-KEM-512", PREFIX + "MLKEMKeyGeneratorSpi$MLKEM512", NISTObjectIdentifiers.id_alg_ml_kem_512);
            addKeyGeneratorAlgorithm(provider, "ML-KEM-768", PREFIX + "MLKEMKeyGeneratorSpi$MLKEM768", NISTObjectIdentifiers.id_alg_ml_kem_768);
            addKeyGeneratorAlgorithm(provider, "ML-KEM-1024", PREFIX + "MLKEMKeyGeneratorSpi$MLKEM1024", NISTObjectIdentifiers.id_alg_ml_kem_1024);

            AsymmetricKeyInfoConverter keyFact = new MLKEMKeyFactorySpi();

            provider.addAlgorithm("Cipher.ML-KEM", PREFIX + "MLKEMCipherSpi$Base");
            provider.addAlgorithm("Alg.Alias.Cipher." + (ASN1ObjectIdentifier) null, "ML-KEM");

            addCipherAlgorithm(provider, "ML-KEM-512", PREFIX + "MLKEMCipherSpi$MLKEM512", NISTObjectIdentifiers.id_alg_ml_kem_512);
            addCipherAlgorithm(provider, "ML-KEM-768", PREFIX + "MLKEMCipherSpi$MLKEM768", NISTObjectIdentifiers.id_alg_ml_kem_768);
            addCipherAlgorithm(provider, "ML-KEM-1024", PREFIX + "MLKEMCipherSpi$MLKEM1024", NISTObjectIdentifiers.id_alg_ml_kem_1024);

            registerOid(provider, (ASN1ObjectIdentifier) null, "ML-KEM", keyFact);
            
            provider.addAlgorithm("Kem.ML-KEM", PREFIX + "MLKEMSpi");
            provider.addAlgorithm("Alg.Alias.Kem", "ML-KEM");
        }
    }
}
