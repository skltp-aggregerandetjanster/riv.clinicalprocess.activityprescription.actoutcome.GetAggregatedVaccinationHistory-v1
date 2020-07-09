package se.skltp.aggregatingservices.riv.clinicalprocess.activityprescription.actoutcome.getaggregatedvaccinationhistory.v1;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistory.v1.rivtabp21.GetVaccinationHistoryResponderInterface;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistory.v1.rivtabp21.GetVaccinationHistoryResponderService;
import se.skltp.aggregatingservices.config.TestProducerConfiguration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="getaggregatedvaccinationhistory.v1.teststub")
public class ServiceConfiguration extends TestProducerConfiguration {

  public static final String SCHEMA_PATH = "/schemas/TD_CLINICALPROCESS_ACTIVITYPRESCRIPTION_ACTOUTCOME_1.0.0/interactions/GetVaccinationHistoryInteraction/GetVaccinationHistoryInteraction_1.0_RIVTABP21.wsdl";

  public ServiceConfiguration() {
    setProducerAddress("http://localhost:8083/vp");
    setServiceClass(GetVaccinationHistoryResponderInterface.class.getName());
    setServiceNamespace("urn:riv:clinicalprocess:activityprescription:actoutcome:GetVaccinationHistoryResponder:1");
    setPortName(GetVaccinationHistoryResponderService.GetVaccinationHistoryResponderPort.toString());
    setWsdlPath(SCHEMA_PATH);
    setTestDataGeneratorClass(ServiceTestDataGenerator.class.getName());
    setServiceTimeout(27000);
  }

}
