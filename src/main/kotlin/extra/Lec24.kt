package extra

import kotlin.system.measureTimeMillis

class Lec24 {
}

// TODO 해야할것
fun something() {
    val a = 1
    val b = 2
}


fun main() {
    // 시간 측정
    val time = measureTimeMillis {
        for (i in 1..1000000) {
            print("")
        }
    }
    println(time)

    // runCatching: 예외를 잡아서 처리
    val result: Result<Int> = runCatching { 1 / 0 }
}


// require: 파라미터를 검증
fun acceptOnlyTwo(num: Int) {
    // 원하는것만 적는다
    require(num == 2) { "2만 허용!" }

    // 원하는게 아닐경우를 적는다
    if(num != 2) {
        throw IllegalArgumentException("2만 허용!")
    }
}

// check: 상태혹은 멤버 변수를 검증
class Person {
    val status: PersonStatus = PersonStatus.PLAYING

    fun sleep() {
        check(this.status == PersonStatus.PLAYING) { "에러 메시지!" }

        if(this.status != PersonStatus.PLAYING) {
            throw IllegalStateException("에러 메시지!")
        }
    }

    enum class PersonStatus {
        PLAYING, SLEEPING
    }
}
