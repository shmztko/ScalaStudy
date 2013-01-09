package org.shmztko

object Sample {

  def main(args: Array[String]): Unit = {
    usingTaple
  }

  def functionTakesAFunctionInArguments = {
    // 関数calcはイカの
    def calc(f:(Int, Int)=>Int, num:Int) = {}

  }


  /**
   * タプル使用方法
   * 生成方法	(値１, 値２, 値３)	val t = (0, "1", 2.0)
   * 代入		val (n, m, s) = t
   * 参照		val n = t._1; val m = t._2; val s = t._3
   *
   * タプルを返すメソッド
   * 	def returnTaple():(Int, String) = {/* do something */}
   * タプルを引数に
   * 	def tapleArguments(value:(Int, Int)) = {/* do something */}
   *
   */
  def usingTaple() = {
    val t = (0, "1", 2.0)
    val (n, m, s) = t
    println(n)
    println(m)
    println(s)
  }

  /**
   * (変数名:型名,……) => 関数本体
   */
  def usingFunctionAsObject() = {
    val f = (value:(Int, Int)) => println(value._1 + value._2)
    val listItems = List((1, 2), (9, 12), (4, 3), (3, 123))
    listItems.foreach(f)

    // Function2 などの Function0 ～ Function22 は引数の数に応じて用意されたTrait
    // Trait => Javaでいうインターフェースのようなもの
    val f2:Function2[Int, Int, String] = (x, y) => (x + y).toString
  }

  /**
   * def 関数名[型パラメータ](引数名:引数の型名,……):返り値 = 関数本体
   */
  def functionSyntax() = {
    def add(x: Int, y: Int): Int = x + y
    add(1, 2)
// 全部同じ
//    def print():Unit = println("Hello")
// Unitは省略可能
//    def print() = println("Hello")
// 引数なしは省略可能
//    def print = println("Hello")
  }

  def patternMatchSyntax_1(x: Int) = {
    x match {
      // break文がなくても他のcase文は実行されない
      case 0 => "これはあかん"
      case 1 => "ええやろ"
      // defaut 的なもの
      case _ => "なんやこれ！？"
    }
  }

  def patternMatchSyntax_2(x: Any) = {
    x match {
      case i: Int => "This is int. -> " + i.toString
      // パターンガード match~case にif文による条件を追加可能
      case s: String if s.length() > 10 => "This string is longer than 10 -> " + s
      case s: String => "This is string. -> " + s
      case _ => "What is this!?"
    }
  }

  def trycatchSyntax(): Int = {
    try {
      "a".toInt
    } catch {
      case e: NumberFormatException => {
        println("NumberFormat exception!!!")
        0
      }
      case e: Exception => {
        println("Other exception!!!")
        1
      }
    } finally {
      println("finally")
    }
  }
  def loopSyntax() = {
    val listItems = List("one", "two", "three", "four", "five")
    val converted = for (item <- listItems if item.length > 3) yield "item=" + item
    println(converted)
  }

  def ifSyntax() = {
    val x = 10
    val hoge = if (x < 10) 10 else 11
    println(hoge)
  }
}