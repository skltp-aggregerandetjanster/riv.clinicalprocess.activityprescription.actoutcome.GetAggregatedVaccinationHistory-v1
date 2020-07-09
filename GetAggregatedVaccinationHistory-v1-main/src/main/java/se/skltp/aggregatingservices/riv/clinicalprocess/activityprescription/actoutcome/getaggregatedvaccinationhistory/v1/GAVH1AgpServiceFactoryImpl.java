package se.skltp.aggregatingservices.riv.clinicalprocess.activityprescription.actoutcome.getaggregatedvaccinationhistory.v1;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistoryresponder.v1.GetVaccinationHistoryResponseType;
import riv.clinicalprocess.activityprescription.actoutcome.getvaccinationhistoryresponder.v1.GetVaccinationHistoryType;
import se.skltp.aggregatingservices.AgServiceFactoryBase;

@Log4j2
public class GAVH1AgpServiceFactoryImpl extends
    AgServiceFactoryBase<GetVaccinationHistoryType, GetVaccinationHistoryResponseType> {

  @Override
  public String getPatientId(GetVaccinationHistoryType queryObject) {
    return queryObject.getPatientId().getId();
  }

  @Override
  public String getSourceSystemHsaId(GetVaccinationHistoryType queryObject) {
    return queryObject.getSourceSystemHSAid();
  }

  @Override
  public GetVaccinationHistoryResponseType aggregateResponse(
      List<GetVaccinationHistoryResponseType> aggregatedResponseList) {

    GetVaccinationHistoryResponseType aggregatedResponse = new GetVaccinationHistoryResponseType();

    for (GetVaccinationHistoryResponseType response : aggregatedResponseList) {
      aggregatedResponse.getVaccinationMedicalRecord().addAll(response.getVaccinationMedicalRecord());
    }

    return aggregatedResponse;
  }
}

