package com.jjballano.howmuch

class Report {

    BigDecimal totalToPay = 0
    BigDecimal alreadyPaid130
    BigDecimal revenue
    BigDecimal expenses

    Map toMap(){
        [totalToPay: totalToPay.round(2), alreadyPaid130: alreadyPaid130.round(2),
         pendingToPaid: (totalToPay - alreadyPaid130).round(2),
        profit: (revenue - expenses - totalToPay).round(2)]
    }
}
