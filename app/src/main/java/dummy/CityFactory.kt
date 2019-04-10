package dummy

class CityFactory {

  val cities = mutableListOf<City>()

  init {
    cities.add(City("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fannabel%2Ffiles%2F2018%2F02%2FDetroit-1200x675.jpg"))
    cities.add(City("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fannabel%2Ffiles%2F2018%2F02%2FSavannah-scenic-of-spanish-moss-1200x795.jpg"))
    cities.add(City("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fannabel%2Ffiles%2F2018%2F02%2FPortland-ME-2-1200x800.jpg"))
    cities.add(City("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fannabel%2Ffiles%2F2018%2F02%2FColumbusATT-SBC-Switching-Center-1200x602.jpg"))
    cities.add(City("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fannabel%2Ffiles%2F2018%2F02%2FRichmond_Maymont-Gardens-1200x795.jpg"))
    cities.add(City("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fannabel%2Ffiles%2F2018%2F02%2FLancaster-Luca-Interior.jpg"))
    cities.add(City("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fannabel%2Ffiles%2F2018%2F02%2FBaltimore-facade-of-the-Sagamore-Pendry-1200x750.jpg"))
    cities.add(City("https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fannabel%2Ffiles%2F2018%2F02%2FSan-Antonio_Riverwalk-1200x801.jpg"))
    cities.add(City("https://www.telegraph.co.uk/content/dam/Travel/2018/January/sydney-best-manly.jpg?imwidth=1240"))
    cities.add(City("https://www.telegraph.co.uk/content/dam/Travel/2017/December/sydney-restaurant.jpg?imwidth=1240"))
    cities.add(City("https://www.telegraph.co.uk/content/dam/Travel/2018/January/sydney-best-hunter-GETTY.jpg?imwidth=1240"))
    cities.add(City("https://www.telegraph.co.uk/content/dam/Travel/2018/January/sydney-best-blue-GETTY.jpg?imwidth=1240"))
    cities.add(City("https://www.telegraph.co.uk/content/dam/Travel/2018/January/sydney-best-bondi-beach-GETTY.jpg?imwidth=1240"))
  }

  companion object {
    val INSTANCE = CityFactory()
  }

  data class City(val url: String?)
}
