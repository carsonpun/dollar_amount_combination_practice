object ExploreCombinations {
  /**
   * method to get all possible combinations for a given total and coinSet
   */
  def getCombinations(total: Int, coinSet: Set[Int]) = {

    // for a given coinSet return the total value
    def coinSetToTotal(coinSet: Map[Int,Int]) = 
      coinSet.map( x=>x._1*x._2).reduce(_+_)

    // recursive call to figure out the valid combinations
    def core(coinMap: Map[Int,Int]): Seq[Map[Int,Int]] = {
      val trials = coinMap.keys.toVector.map {
        faceValue=> 
          val remaining = coinMap.filter(x => x._1 != faceValue)
          remaining + (faceValue->(coinMap(faceValue)+1))
      }
      trials.map{ x => (x,coinSetToTotal(x)) }
            .collect {
              _ match {
                case x if x._2 == total => Seq(x._1)
                case x if x._2 < total => core(x._1)
              }}
            .toSeq
            .flatMap(x=>x)
    }

    // initial call to core with input argument for all coins counter set to 0
    core(coinSet.map( x=>(x,0) ).toMap)
  }

  def main(args: Array[String]) {
    val tmp = args.size match {
      case x if x > 1 => Some(args.map(_.toInt))
      case _ => None
    }
    if (!tmp.isDefined) {
      println("Usage:: run dollarAmount cointype1 cointype2 ...")
    } else {
      val (amt, coinSet) = tmp.get.toSeq match {
        case h +: r => (h,r.toSet)
      }
      val results = getCombinations(amt, coinSet)
      results.foreach { println }
      println("-"*30)
      println(s"total number of solutions: ${results.size}")
    }
  }
}
