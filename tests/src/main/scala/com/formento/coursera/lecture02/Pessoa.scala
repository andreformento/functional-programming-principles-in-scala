package com.formento.coursera.lecture02

class Pessoa {

  val nome = "Andre"

  def +(sobrenome: String) = {
    nome + sobrenome
  }

  def main(args: Array[String]): Unit = {
    val p: Pessoa = new Pessoa()

    val nomeCompleto = p + " Formento"

    printf(nomeCompleto)
  }

}
