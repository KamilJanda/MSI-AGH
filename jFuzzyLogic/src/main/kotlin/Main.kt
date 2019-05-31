@file:JvmName("Main")


import net.sourceforge.jFuzzyLogic.FIS

fun main(args: Array<String>) = try {
    val fileName = "fuzzy_controller.fcl"
    val yearsOfExperience = Integer.parseInt(args[0])
    val iq = Integer.parseInt(args[1])
    val communicativeness = Integer.parseInt(args[2])


    val fis = FIS.load(fileName, false)
    val fuzzyRuleSet = fis.fuzzyRuleSet

    fuzzyRuleSet.chart()

    fuzzyRuleSet.setVariable("years_of_experience", yearsOfExperience.toDouble())
    fuzzyRuleSet.setVariable("iq", iq.toDouble())
    fuzzyRuleSet.setVariable("communicativeness", communicativeness.toDouble())

    fuzzyRuleSet.evaluate()

    fuzzyRuleSet.getVariable("match_to_the_team").chartDefuzzifier(true)

    System.out.println(fuzzyRuleSet)

} catch (ex:ArrayIndexOutOfBoundsException) {
    System.out.println("Too few arguments have been passed!")
} catch (ex:NumberFormatException) {
    System.out.println("Wrong parameter format!")
} catch (ex:Exception) {
    System.out.println(ex.toString())
}

