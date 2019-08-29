package mr.cell.schedulers

import java.text.SimpleDateFormat
import java.util.*

fun Date.defaultFormat() = SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(this)