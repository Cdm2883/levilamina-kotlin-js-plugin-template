package vip.cdms.lse.dsl.form

import Player

interface FormBuilder {
    var title: String?
    infix fun send(player: Player)
}
infix fun Player.send(builder: FormBuilder) = builder.send(this)
