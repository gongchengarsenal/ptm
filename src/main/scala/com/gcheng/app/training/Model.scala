package com.gcheng.app.training

import org.apache.spark.Logging
import org.apache.spark.rdd.RDD

class Model (
  val nTopic: Int,
  val nTerm: Int,
  var alpha: Array[Double],
  var beta: Array[Double]
) extends Serializable {
  require(alpha.length == nTopic && beta.length == nTerm)

  val theta: Array[Array[Double]] = ???
  var phi: Array[Array[Double]] = ???

  def getDocTopic(docId: Int): Array[Double] = ???

  def getDocTopic(doc: Array[(Int, Int)]) = ???

  def getTopicTerm(topicId: Int): (Array[(Int, Double)]) = ???
}

object Model extends Logging {
  def build(docs: RDD[Array[(Int, Int)]], optimizer: Optimizer, conf: Config): Model = {
    val model = new Model(conf.nTopic, conf.nTerm,
      Array.fill(conf.nTopic)(conf.alpha), Array.fill(conf.nTerm)(conf.beta))
    Range(0, conf.maxIter).foreach(_ => optimizer.update(model, docs))
    model
  }
}

case class Config (
  nTopic: Int,
  nTerm: Int,
  maxIter: Int,
  alpha: Double,
  beta: Double
)