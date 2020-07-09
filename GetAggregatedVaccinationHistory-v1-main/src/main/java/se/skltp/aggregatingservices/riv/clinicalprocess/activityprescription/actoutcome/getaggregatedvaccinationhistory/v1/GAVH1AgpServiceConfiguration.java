package se.skltp.aggregatingservices.riv.clinicalprocess.activityprescription.actoutcome.getaggregatedvaccinationhistory.v1;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistory.v1.rivtabp21.GetVaccinationHistoryResponderInterface;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistory.v1.rivtabp21.GetVaccinationHistoryResponderService;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "getaggregatedvaccinationhistory.v1")
public class GAVH1AgpServiceConfiguration extends se.skltp.aggregatingservices.configuration.AgpServiceConfiguration {

public static final String SCHEMA_PATH = "/schemas/TD_CLINICALPROCESS_ACTIVITYPRESCRIPTION_ACTOUTCOME_1.0.0/interactions/GetVaccinationHistoryInteraction/GetVaccinationHistoryInteraction_1.0_RIVTABP21.wsdl";

  public GAVH1AgpServiceConfiguration() {

    setServiceName("GetAggregatedVaccinationHistory-v1");
    setTargetNamespace("urn:riv:clinicalprocess:activityprescription:actoutcome:GetVaccinationHistory:1:rivtabp21");

    // Set inbound defaults
    setInboundServiceURL("http://localhost:9004/GetAggregatedVaccinationHistory/service/v1");
    setInboundServiceWsdl(SCHEMA_PATH);
    setInboundServiceClass(GetVaccinationHistoryResponderInterface.class.getName());
    setInboundPortName(GetVaccinationHistoryResponderService.GetVaccinationHistoryResponderPort.toString());

    // Set outbound defaults
    setOutboundServiceWsdl(SCHEMA_PATH);
    setOutboundServiceClass(GetVaccinationHistoryResponderInterface.class.getName());
    setOutboundPortName(GetVaccinationHistoryResponderService.GetVaccinationHistoryResponderPort.toString());

    // FindContent
    setEiServiceDomain("riv:clinicalprocess:activityprescription:actoutcome");
    setEiCategorization("caa-gvh");

    // TAK
    setTakContract("urn:riv:clinicalprocess:activityprescription:actoutcome:GetVaccinationHistoryResponder:1");

    // Set service factory
    setServiceFactoryClass(GAVH1AgpServiceFactoryImpl.class.getName());
    }


}
