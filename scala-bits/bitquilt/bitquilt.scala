/*
  As seen in Donald Knuths TAOCP VOL. 4 FASC. 1
  Section 7.1.3, page 4.
  Knuth attributes original design to D. Sleator, 1976.
  --Tyler Fochtman, 2014
 */

import scala.swing._
object bitquilt extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "bit quilt" 
    contents = new Panel { 
      val xDim = 256 
      val yDim = 512 
      preferredSize = new Dimension(xDim, yDim)
      val quilt = 
        (1 to xDim).toVector map (x =>
          (1 to yDim).toVector map (y => {
              val a = (x ^ ~y) & (x - 350) >> 3
              (a * a) >> 12 & 1
            }))
      override def paintComponent(g: Graphics2D): Unit = {
        g.setColor(java.awt.Color.BLACK)
        for (i <- (0 to xDim-1); j <- (0 to yDim-1)) {
          quilt(i)(j) match {
            case 1 => g.fillRect(i, j, 1, 1) 
            case _ => 
          }
        }
      }
    }
  }
}
