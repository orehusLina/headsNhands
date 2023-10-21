import kotlin.math.*
import kotlin.random.Random

open class Creature(
    protected var n: String, protected var a: Int, protected var d: Int, protected var h: Pair<Double,Double>, protected var y: Pair<Int,Int>
) {  // конструктор базового класса

    var name: String = n  // имя существа
        get() = field
        set(value) {
            if (value != "")
                field = value
            else 
                throw Exception("Empty name!")
        }
        
    var attack: Int = a  // аттака (целое число от 1 до 30)
        get() = field 
        set(value) {
            if (value in 1..30)
                field = value
            else 
                throw Exception("Wrong attack range!")
        }
    
    var defend: Int = d  // защита (целое число от 1 до 30)
        get() = field
        set(value) {
            if (value in 1..30)
                field = value
            else 
                throw Exception("Wrong defend range!")
        }
    
    // пара (текущее здоровье, максимальное здоровье)
    var health: Pair<Double,Double> = h 
        get() = field
        set(value) {
            if ((value.first > 0) and (value.first <= value.second))
                field = value
            else 
                throw Exception("Wrong health range!")
        }
    
    // пара - диапазон урона
    var yron: Pair<Int,Int> = y
        get() = field
        set(value) {
            if ((value.second > 0) and (value.second <= value.first))
                field = value
            else 
                throw Exception("Wrong yron range!")
        }
    
    // проверка живости
    fun checkDead() : Boolean {
        if (health.first < 1) return true;
        return false;
    }
    

    fun kickSomeAss(fighter : Creature, victim : Creature) {
        var modifier : Int = fighter.attack - victim.defend + 1
        for (i in 0..max(1, modifier)) {
            var k : Int = Random.nextInt(1, 6) // генерация чисел от 1 до 6 включительно
            if (k > 4) {
                // берем произвольное значение из промежутка урона аткующего
                var kick : Int = Random.nextInt(fighter.yron.first, fighter.yron.second) 
                victim.health = Pair(victim.health.first - kick, victim.health.second)
            }
        }
    }
    
}

class Programmer(
    n: String, a: Int, d: Int, h: Pair<Double,Double>, y: Pair<Int, Int>
) : Creature(n, a, d, h, y) {
    var leftHeal = 4  // количество оставшихся хилок
        get() = field
    
    private fun useLeftHeal() { 
        leftHeal--
    }
    
    fun healYourself() {  // использование хилки игроком
        if (leftHeal > 0) {
            useLeftHeal()
            health = Pair(health.first + 0.3 * health.second, health.second)
        }
    }
    
    fun print() {  // вывод 
        val y1 : Int = yron.first
        val y2 : Int = yron.second
        val h1 : Double = health.first
        val h2 : Double = health.second
        println("Программист $name имеет атаку $attack, защиту $defend и урон $y1 - $y2.") 
        println("Здоровье составляет $h1 из $h2.")
        println("Оставшиеся хилки: $leftHeal шт.")
    }
}

class Manager(
    n: String, a: Int, d: Int, h: Pair<Double,Double>, y: Pair<Int, Int>
) : Creature(n, a, d, h, y) {
    
    fun print() {  // тоже вывод
        val y1 : Int = yron.first
        val y2 : Int = yron.second
        val h1 : Double = health.first
        val h2 : Double = health.second
        println("Проджект $name имеет атаку $attack, защиту $defend и урон $y1 - $y2.") 
        println("Здоровье составляет $h1 из $h2.")
    }
}

fun main() {
    var firstPerson: Manager = Manager("Tom", 20, 20, 1.0 to 100.0, 30 to 40)
    firstPerson.print()
}
