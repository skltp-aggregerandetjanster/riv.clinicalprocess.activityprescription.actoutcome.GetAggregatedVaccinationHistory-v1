package se.skltp.aggregatingservices.riv.clinicalprocess.activityprescription.actoutcome.getaggregatedvaccinationhistory

import se.skltp.agp.testnonfunctional.TPHappyPathAbstract

/**
 * Just test Tolvan Tolvansson - no error latency
 */
class TPHappyPath extends TPHappyPathAbstract with CommonParameters {
  setUp(setUpAbstract(serviceName, urn, responseElement, responseItem, baseUrl, Some(responseItemUrn)))
}
