package com.haulmer.paymentexample.model

class Request(
    var amount: Int? = -1,
    var tip: Int? = -1,
    var cashback: Int? = -1,
    var method: Int? = -1,
    var installmentsQuantity: Int? = -1,
    var printVoucherOnApp: Boolean? = false,
    var dteTpe: Int? = -1,
    var extraData: ExtraDataRequest? = null,
) {
    override fun toString(): String {
        return "[$amount,$tip,$cashback,$method,$installmentsQuantity,$printVoucherOnApp,$dteTpe,$extraData]"
    }
}