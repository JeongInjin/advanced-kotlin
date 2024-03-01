package function


class Lec13 {

}

/**
 * 고참함수: 파라미터로 함수를 받거나 함수를 반환하는 함수
 * 함수값 / 함수 리터널: 일반 함수와 달리 변수로 간주하거나 파라미터에 넣을 수 있는 함수
 * 함수 리터널: 소스 코드의 고정된 값을 나타내는 표기법
 */
fun main() {
  // 람다식
  // compute(5, 3) { a, b -> a + b }

  // 익명함수
  // compute(5, 3, fun(a, b) = a + b)

  iterate(listOf(1, 2, 3, 4, 5)) { num ->
    if (num != 3) {
      println(num)
    }
  }

  println("ABC")
}


//fun iterate(numbers: List<Int>, exec: (Int) -> Unit) {
//  for (number in numbers) {
//    exec(number)
//  }
//}

fun calculate(num1: Int, num2: Int, oper: Operator): Int = oper(num1, num2)

enum class Operator(
  private val oper: Char,
  private val calcFun: (Int, Int) -> Int,
) {
  PLUS('+', { a, b -> a + b }),
  MINUS('-', { a, b -> a - b }),
  MULTIPLY('-', { a, b -> a * b }),
  DIVIDE('-', { a, b ->
    if (b == 0) {
      throw IllegalArgumentException("0으로 나눌 수 없습니다!")
    } else {
      a / b
    }
  }),
  ;

  operator fun invoke(num1: Int, num2: Int): Int {
    return this.calcFun(num1, num2)
  }

}
