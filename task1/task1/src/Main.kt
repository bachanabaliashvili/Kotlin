fun main() {

    println(isPalindrome("qwertyuiop"))
    println(isPalindrome("abba"))
    println(sumOfEvenIndexes(arrayOf(10,23,45,40,12,23,34)))
    println(sumOfEvenIndexes(arrayOf(23,65,23,67)))

}
fun isPalindrome(word:String):Boolean{
    val wordLength : Int = word.length

    for (i in 0 until  wordLength/2)
    {
        if (word[i]!=word[wordLength-i-1])
        {
            return false
        }
    }
    return true
}
fun sumOfEvenIndexes(a:Array<Int>):Int
{
    var sum = 0
    for (i in 0 until a.size step 2)
    {
        sum+=a[i]
    }
    return sum
}