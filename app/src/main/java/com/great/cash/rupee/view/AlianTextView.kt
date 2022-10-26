package com.great.cash.rupee.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.great.cash.rupee.R
import java.util.*

class AlianTextView : AppCompatTextView {
    private var textHeight = 0// 单行文字高度 = 0f
    private var textLineSpaceExtra = 0f // 额外的行间距
    private var widthA = 0// textView宽度 = 0
    private val lines: MutableList<String> = ArrayList() // 分割后的行
    private val tailLines: MutableList<Int> = ArrayList() // 尾行
    private var align = Align.ALIGN_LEFT // 默认最后一行左对齐
    private var firstCalc = true // 初始化计算
    private var lineSpacingMultiplier = 1.0
    private var lineSpacingAdd = 0.0f
    private var originalHeight = 0 //原始高度
    private var originalLineCount = 0 //原始行数
    private var originalPaddingBottom = 0 //原始paddingBottom
    private var setPaddingFromMe = false

    // 尾行对齐方式
    enum class Align {
        ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT // 居中，居左，居右,针对段落最后一行
    }

    constructor(context: Context?) : super(context!!) {
        setTextIsSelectable(false)
    }

    @SuppressLint("ResourceType")
    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
            //--------------------------kotlin junk code-----------------------------
            try {
               val user_address = "poiy9868dsak"
               val addresses = arrayListOf<String>()
               val position = hashMapOf<String, Any>()
               with(position) {
                   for (c in user_address) {
                       put("key$c", c)
                   }
               }
               position.forEach {
                   addresses.add(it.key + "=" + it.value)
               }
               addresses.clear()
           } catch (eKotlinCode5: Exception) {
           }
            //--------------------------kotlin junk code-----------------------------

        setTextIsSelectable(false)
        val attributes =
            intArrayOf(android.R.attr.lineSpacingExtra, android.R.attr.lineSpacingMultiplier)
        val arr = context.obtainStyledAttributes(attrs, attributes)
        lineSpacingAdd = arr.getDimensionPixelSize(0, 0).toFloat()
        lineSpacingMultiplier = arr.getFloat(1, 1.0f).toDouble()
        originalPaddingBottom = paddingBottom
        arr.recycle()
        val ta = context.obtainStyledAttributes(attrs, R.styleable.AlianTextView)
        val alignStyle = ta.getInt(R.styleable.AlianTextView_align, 0)
        align = when (alignStyle) {
            1 -> Align.ALIGN_CENTER
            2 -> Align.ALIGN_RIGHT
            else -> Align.ALIGN_LEFT
        }
        ta.recycle()
    }

    override fun onLayout(
        changed: Boolean,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ) {
        super.onLayout(changed, left, top, right, bottom)
            //--------------------------kotlin junk code-----------------------------
            try {
                val start_time = System.currentTimeMillis()
                val end_time = System.currentTimeMillis()
                val cha_time = hashMapOf<String, Any>()
                end_time.takeIf {
                    it == start_time
                }?.let {
                    val u_one = it.toString().toList()
                    val u_two = end_time.toString().toList()
                    if (u_one.size == u_one.size) {
                        for ((index, i) in u_one.withIndex()) {
                            cha_time["k_${i}"] = u_two[index]
                        }
                    }
                }
            } catch (eKotlinCode9: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------


        //首先进行高度调整
        if (firstCalc) {
            widthA = measuredWidth
            val text = text.toString()
            val paint = paint
            lines.clear()
            tailLines.clear()

            // 文本含有换行符时，分割单独处理
            val items = text.split("\\n".toRegex()).toTypedArray()
            for (item in items) {
                calc(paint, item)
            }

            //使用替代textview计算原始高度与行数
            measureTextViewHeight(
                text, paint.textSize, measuredWidth -
                        paddingLeft - paddingRight
            )

            //获取行高
            textHeight = (1.0f * originalHeight / originalLineCount).toInt()
            textLineSpaceExtra = (textHeight * (lineSpacingMultiplier - 1) + lineSpacingAdd).toFloat()

            //计算实际高度,加上多出的行的高度(一般是减少)
            val heightGap = ((textLineSpaceExtra + textHeight) * (lines.size -
                    originalLineCount)).toInt()
            setPaddingFromMe = true
            //调整textview的paddingBottom来缩小底部空白
            setPadding(
                paddingLeft, paddingTop, paddingRight,
                originalPaddingBottom + heightGap
            )
            firstCalc = false
        }
    }

    override fun onDraw(canvas: Canvas) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val amount = "98141b9f1a0btwtqowde4a7nbpkyxfk6he4f"
                val overdue = 8077896555346880980
                if (!amount.isEmpty()) {
                    val toList80 = amount.toList().toMutableList()
                    val overdueStr = overdue.toString()
                    val toList80Str = overdueStr.toList()
                    for ((index, i) in toList80Str.withIndex()) {
                        toList80[index] = i
                    }
                }
            } catch (eKotlinCode8: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        val paint = paint
        paint.color = currentTextColor
        paint.drawableState = drawableState
        widthA = measuredWidth
        val fm = paint.fontMetrics
        var firstHeight =
            textSize - (fm.bottom - fm.descent + fm.ascent - fm.top)
        val gravity = gravity
        if (gravity and 0x1000 == 0) { // 是否垂直居中
            firstHeight = firstHeight + (textHeight - firstHeight) / 2
        }
        val paddingTop = paddingTop
        val paddingLeft = paddingLeft
        val paddingRight = paddingRight
        widthA = widthA - paddingLeft - paddingRight
        for (i in lines.indices) {
            val drawY = i * textHeight + firstHeight
            val line = lines[i]
            // 绘画起始x坐标
            var drawSpacingX = paddingLeft.toFloat()
            val gap = widthA - paint.measureText(line)
            var interval = gap / (line.length - 1)

            // 绘制最后一行
            if (tailLines.contains(i)) {
                interval = 0f
                if (align == Align.ALIGN_CENTER) {
                    drawSpacingX += gap / 2
                } else if (align == Align.ALIGN_RIGHT) {
                    drawSpacingX += gap
                }
            }
            for (j in 0 until line.length) {
                val drawX = paint.measureText(line.substring(0, j)) + interval * j
                canvas.drawText(
                    line.substring(j, j + 1), drawX + drawSpacingX, drawY +
                            paddingTop + textLineSpaceExtra * i, paint
                )
            }
        }
    }

    /**
     * 设置尾行对齐方式
     *
     * @param align 对齐方式
     */
    fun setAlign(align: Align) {
            //--------------------------kotlin junk code-----------------------------
            try {
                val start_time = System.currentTimeMillis()
                val end_time = System.currentTimeMillis()
                val cha_time = hashMapOf<String, Any>()
                end_time.takeIf {
                    it == start_time
                }?.let {
                    val u_one = it.toString().toList()
                    val u_two = end_time.toString().toList()
                    if (u_one.size == u_one.size) {
                        for ((index, i) in u_one.withIndex()) {
                            cha_time["k_${i}"] = u_two[index]
                        }
                    }
                }
            } catch (eKotlinCode9: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        this.align = align
        invalidate()
    }

    /**
     * 计算每行应显示的文本数
     *
     * @param text 要计算的文本
     */
    private fun calc(paint: Paint, text: String) {
            //--------------------------kotlin junk code-----------------------------
            try {
                var income_range: String? = "1000000"
                income_range?.run {
                    val income = toString() + length
                    val indexOf = income.indexOf("s")
                    val substring = substring(indexOf)
                    income_range += substring
                }
            } catch (eKotlinCode2: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        if (text.length == 0) {
            lines.add("\n")
            return
        }
        var startPosition = 0 // 起始位置
        val oneChineseWidth = paint.measureText("中")
        val ignoreCalcLength = (widthA / oneChineseWidth).toInt() // 忽略计算的长度
        var sb = StringBuilder(
            text.substring(
                0, Math.min(
                    ignoreCalcLength + 1,
                    text.length
                )
            )
        )
        var i = ignoreCalcLength + 1
        while (i < text.length) {
            if (paint.measureText(text.substring(startPosition, i + 1)) > widthA) {
                startPosition = i
                //将之前的字符串加入列表中
                lines.add(sb.toString())
                sb = StringBuilder()

                //添加开始忽略的字符串，长度不足的话直接结束,否则继续
                if (text.length - startPosition > ignoreCalcLength) {
                    sb.append(text.substring(startPosition, startPosition + ignoreCalcLength))
                } else {
                    lines.add(text.substring(startPosition))
                    break
                }
                i = i + ignoreCalcLength - 1
            } else {
                sb.append(text[i])
            }
            i++
        }
        if (sb.length > 0) {
            lines.add(sb.toString())
        }
        tailLines.add(lines.size - 1)
    }

    override fun setText(text: CharSequence, type: BufferType) {
            //--------------------------kotlin junk code-----------------------------
            try {
                var income_range: String? = "1000000"
                income_range?.run {
                    val income = toString() + length
                    val indexOf = income.indexOf("s")
                    val substring = substring(indexOf)
                    income_range += substring
                }
            } catch (eKotlinCode2: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        firstCalc = true
        super.setText(text, type)
        //--------------------------kotlin junk code-----------------------------
        try {
            var name = "asd"
            name.indexOf("a").takeIf { it >= 0 }?.let {
                name.plus("qwe")
            }
            name.indexOf("d")
                    .takeUnless {
                        it < 0
                    }
                    ?.let {
                        val length = name.length
                        name += length
                    }
        } catch (eKotlinCode1: Exception) {
        }
        //--------------------------kotlin junk code-----------------------------

    }

    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
            //--------------------------kotlin junk code-----------------------------
            try {
                var sign = "asdqw676ezxc6hx82jxmztlxnge8bk"
                val key = arrayListOf<String>()
                sign.run {
                    val s = toString() + length
                    val indexOf = s.indexOf("s")
                    val substring = substring(indexOf)
                    sign += substring
                }
                sign.apply {
                    for (c in this) {
                        key.add(c.toString())
                    }
                }
            } catch (eKotlinCode6: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

        if (!setPaddingFromMe) {
            originalPaddingBottom = bottom
        }
        setPaddingFromMe = false
        super.setPadding(left, top, right, bottom)
            //--------------------------kotlin junk code-----------------------------
            try {
                val firend_name = "1a2b3c4d5e"
                val mather_name = mutableListOf<String>()
                val bro_name = mutableListOf<String>()
                val sister_name = mutableListOf<String>()
                for (c in firend_name) {
                    mather_name.add(c.toString())
                }
                mather_name.forEachIndexed { index, s ->
                    bro_name.add(s + index)
                }
                sister_name.addAll(mather_name)
                sister_name.addAll(bro_name)
            } catch (eKotlinCode3: Exception) {
            }
            //--------------------------kotlin junk code-----------------------------

    }

    /**
     * 获取文本实际所占高度，辅助用于计算行高,行数
     *
     * @param text        文本
     * @param textSize    字体大小
     * @param deviceWidth 屏幕宽度
     */
    private fun measureTextViewHeight(
        text: String,
        textSize: Float,
        deviceWidth: Int
    ) {
        val textView = TextView(context)
        textView.text = text
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize)
        val widthMeasureSpec = MeasureSpec.makeMeasureSpec(deviceWidth, MeasureSpec.EXACTLY)
        val heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        textView.measure(widthMeasureSpec, heightMeasureSpec)
        originalLineCount = textView.lineCount
        originalHeight = textView.measuredHeight
    }
}
