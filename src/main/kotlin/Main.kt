class CoffeeMachine(
    private var waterCapacity: Int = 400,
    private var milkCapacity: Int = 540,
    private var beansCapacity: Int = 120,
    private var cups: Int = 9,
    private var money: Int = 550) {

    private fun isEnoughResources (water: Int, milk: Int, beans: Int): Boolean {
        if (water > this.waterCapacity) {
            println("Sorry, not enough water!")
            return false
        } else if (milk > this.milkCapacity)  {
            println("Sorry, not enough milk!")
            return false
        } else if (beans > this.beansCapacity) {
            println("Sorry, not enough beans!")
            return false
        }
        println("I have enough resources, making you a coffee!")
        return true
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when(readln()) {
            "1" -> {
                if (!isEnoughResources(water = 250, milk = 0, beans = 16)) return
                this.waterCapacity -= 250
                this.beansCapacity -= 16
                this.money += 4
                this.cups --
            }
            "2" -> {
                if (!isEnoughResources(water = 350, milk = 75, beans = 20)) return
                this.waterCapacity -= 350
                this.milkCapacity -= 75
                this.beansCapacity -= 20
                this.money += 7
                this.cups --
            }
            "3" -> {
                if (!isEnoughResources(water = 200, milk = 100, beans = 12)) return
                this.waterCapacity -= 200
                this.milkCapacity -= 100
                this.beansCapacity -= 12
                this.money += 6
                this.cups --
            }
            "back" -> return
        }
    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        this.waterCapacity += readln().toInt()
        println("Write how many ml of milk you want to add:")
        this.milkCapacity += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        this.beansCapacity += readln().toInt()
        println("Write how many disposable cups you want to add:")
        this.cups += readln().toInt()
    }

    fun take() {
        println("I gave you $${this.money}")
        this.money = 0
    }

    fun remaining() {
        println("""
       The coffee machine has:
       ${this.waterCapacity} ml of water
       ${this.milkCapacity} ml of milk
       ${this.beansCapacity} g of coffee beans
       ${this.cups} disposable cups
       $${this.money} of money 
    """.trimIndent())
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    while (true){
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> coffeeMachine.buy()
            "fill" -> coffeeMachine.fill()
            "take" -> coffeeMachine.take()
            "remaining" -> coffeeMachine.remaining()
            "exit" -> return
        }
    }
}
