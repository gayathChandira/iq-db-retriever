package com.iit.iqdbretriever.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.GetParameterResponse;


@Configuration
public class AwsParameterStoreConfig {

    @Value("${AWS_ACCESS_KEY_ID}")
    private String accessKey;

    @Value("${AWS_SECRET_ACCESS_KEY}")
    private String secretKey;


    @Bean
    public AwsCredentialsProvider awsCredentialsProvider() {
        return StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey));
    }

    @Bean
    public SsmClient ssmClient(AwsCredentialsProvider awsCredentialsProvider) {
        return SsmClient.builder()
                .credentialsProvider(awsCredentialsProvider)
                .build();
    }

//    @Bean
//    public String dataSourceUrl(AwsCredentialsProvider awsCredentialsProvider) {
//        SsmClient ssmClient = SsmClient.builder()
//                .region(Region.US_EAST_1)
//                .credentialsProvider(awsCredentialsProvider)
//                .build();
//
//        GetParameterRequest parameterRequest = GetParameterRequest.builder()
//                .name("/developeriq/iq-store-db-url")
//                .build();
//
//        GetParameterResponse parameterResponse = ssmClient.getParameter(parameterRequest);
//        return parameterResponse.parameter().value();
//    }


}
