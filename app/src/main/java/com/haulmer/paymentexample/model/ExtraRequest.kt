package com.haulmer.paymentexample.model

class ExtraDataRequest(
    var taxIdnValidation: String? = null,
    var exemptAmount: Int? = -1,
    var netAmount: Int? = -1,
    var sourceName: String? = null,
    var sourceVersion: String? = null,
    var idProviderAccount: String? = null,
    var flagAccountPayProvider: Boolean? = true,
    var externalReferenceId: String? = null,

    ) {
    override fun toString(): String {
        return "[$taxIdnValidation,$exemptAmount,$netAmount,$sourceName,$sourceVersion,$idProviderAccount,$flagAccountPayProvider,$externalReferenceId]"
    }
}