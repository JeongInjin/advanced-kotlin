package generic

fun main() {
  val cage: Cage2<out Fish> = Cage2<GoldFish>()

  val goldFishCage = Cage2<GoldFish>()
  goldFishCage.put(GoldFish("금붕어"))

  val fishCage = Cage2<Fish>()
  fishCage.moveFrom(goldFishCage)
  println(fishCage.getFirst().name)
}

class Cage2<T : Any> {
  private val animals: MutableList<T> = mutableListOf()

  fun getFirst(): T {
    return animals.first()
  }

  fun put(animal: T) {
    this.animals.add(animal)
  }

  fun moveFrom(otherCage: Cage2<out T>) {
    this.animals.addAll(otherCage.animals)
  }

  fun moveTo(otherCage: Cage2<in T>) {
    otherCage.animals.addAll(this.animals)
  }
}
