package com.gcheng.app.training

import org.apache.spark.rdd.RDD

trait Optimizer {
  def update(model: Model, docs: RDD[Array[(Int, Int)]]): Unit
}

class MAPOptimizer extends Optimizer {
  override def update(model: Model, docs: RDD[Array[(Int, Int)]]): Unit = {
    // E step: topic distribution conditioned on doc and term
  }
}

class CVB0Optimizer extends Optimizer{
  override def update(model: Model, docs: RDD[Array[(Int, Int)]]): Unit = ???
}