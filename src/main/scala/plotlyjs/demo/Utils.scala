package plotlyjs.demo
/*
 * Copyright (C) 24/03/16 // mathieu.leclaire@openmole.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 */

import org.openmole.plotlyjs.Plotly.Root
import org.openmole.plotlyjs.PlotlyHTMLElement
import org.querki.jsext.JSOptionBuilder
import org.scalajs.dom.HTMLDivElement

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.JSConverters._
object Utils {

  lazy val rng = scala.util.Random

  val viridis = Seq(
    "440154",
    "481567",
    "482677",
    "453781",
    "404788",
    "39568C",
    "33638D",
    "2D708E",
    "287D8E",
    "238A8D",
    "1F968B",
    "20A387",
    "29AF7F",
    "3CBB75",
    "55C667",
    "73D055",
    "95D840",
    "B8DE29",
    "DCE319",
    "FDE725"
  )

  def randomDoubles(nb: Int = 100, ratio: Int = 1000) =
    Seq.fill(nb)(rng.nextDouble * ratio).toJSArray

  def randomDoublesAsStrings(nb: Int = 100, ratio: Int = 1000) =
    Seq.fill(nb)((rng.nextDouble * ratio).toString).toJSArray

  def randomInts(nb: Int = 100, ratio: Int = 1000) =
    Seq.fill(nb)(rng.nextInt(ratio)).toJSArray

  def anArray = Array(4.9, 4.7, 4.6, 5.0, 5.4, 4.6, 5.0, 4.4, 4.9, 5.4, 4.8,
    4.8, 4.3, 5.8, 5.7, 5.4, 5.1, 5.7, 5.1, 5.4, 5.1, 4.6, 5.1, 4.8, 5.0, 5.0,
    5.2, 5.2, 4.7, 4.8, 5.4, 5.2, 5.5, 4.9, 5.0, 5.5, 4.9, 4.4, 5.1, 5.0, 4.5,
    4.4, 5.0, 5.1, 4.8, 5.1, 4.6, 5.3, 5.0, 7.0, 6.4, 6.9, 5.5, 6.5, 5.7, 6.3,
    4.9, 6.6, 5.2, 5.0, 5.9, 6.0, 6.1, 5.6, 6.7, 5.6, 5.8, 6.2, 5.6, 5.9, 6.1,
    6.3, 6.1, 6.4, 6.6, 6.8, 6.7, 6.0, 5.7, 5.5, 5.5, 5.8, 6.0, 5.4, 6.0, 6.7,
    6.3, 5.6, 5.5, 5.5, 6.1, 5.8, 5.0, 5.6, 5.7, 5.7, 6.2, 5.1, 5.7, 6.3, 5.8,
    7.1, 6.3, 6.5, 7.6, 4.9, 7.3, 6.7, 7.2, 6.5, 6.4, 6.8, 5.7, 5.8, 6.4, 6.5,
    7.7, 7.7, 6.0, 6.9, 5.6, 7.7, 6.3, 6.7, 7.2, 6.2, 6.1, 6.4, 7.2, 7.4, 7.9,
    6.4, 6.3, 6.1, 7.7, 6.3, 6.4, 6.0, 6.9, 6.7, 6.9, 5.8, 6.8, 6.7, 6.7, 6.3,
    6.5, 6.2, 5.9).toJSArray

  object PlotlyImplicitsAdditional {
//    to avoid chained implicits problem
    implicit def elToRoot[T <: HTMLDivElement](element: T): Root =
      element.asInstanceOf[PlotlyHTMLElement]
    // returned from comments
    implicit def thisBuilderToUndefForThis[T <: js.Object, B <: JSOptionBuilder[
      T,
      _
    ]](b: JSOptionBuilder[T, B]): js.UndefOr[T] = b._result

  }
}
