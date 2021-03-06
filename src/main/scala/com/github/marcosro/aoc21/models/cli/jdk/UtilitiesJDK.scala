package com.github.marcosro.aoc21.models.cli.jdk

import scala.io.AnsiColor

private object UtilitiesJDK:
  private val aoc21 = f"""${AnsiColor.BOLD}${AnsiColor.YELLOW}
 ______     _____     __   __   ______     __   __     ______      ______     ______      ______     ______     _____     ______    
 /\  __ \   /\  __-.  /\ \ / /  /\  ___\   /\ "-.\ \   /\__  _\    /\  __ \   /\  ___\    /\  ___\   /\  __ \   /\  __-.  /\  ___\   
 \ \  __ \  \ \ \/\ \ \ \ \'/   \ \  __\   \ \ \-.  \  \/_/\ \/    \ \ \/\ \  \ \  __\    \ \ \____  \ \ \/\ \  \ \ \/\ \ \ \  __\   
  \ \_\ \_\  \ \____-  \ \__|    \ \_____\  \ \_\\"\_\    \ \_\     \ \_____\  \ \_\       \ \_____\  \ \_____\  \ \____-  \ \_____\ 
    \/_/\/_/   \/____/   \/_/      \/_____/   \/_/ \/_/     \/_/      \/_____/   \/_/        \/_____/   \/_____/   \/____/   \/_____/ 
                                                                                                                                        
  ${AnsiColor.RESET}"""

  def banner: Unit =
    println(aoc21)
