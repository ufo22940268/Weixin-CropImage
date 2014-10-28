Weixin-CropImage
================

像微信，facebook 一样截图,支持pinch

产品经理说要做一个图片上传的功能。结果也不知道该做成什么样的，就说做成和微信一样吧。然后过了一段时间发现微信的那个截图的拖拽起来有点卡（我的 nexus5上，<span style="text-decoration: line-through">微信大牛们要算账找我们产品狗啊</span>）,然后就说要做成想 facebook 一样，真是太调皮了。因为放狗搜遍了都没有找到满足要求的开源程序，而且之前也尝试对[android-crop](https://github.com/jdamcd/android-crop)进行二次修改，发现还是不行。最后就在[PhotoView](https://github.com/chrisbanes/PhotoView)的基础上进行二次开发了。

长什么样
==========
![](./screenshot.png)

怎么用
=====

- 导入 library 就可以直接用CropView了。

比如：

    <com.bettycc.cropimage.library.CropView
        android:id="@+id/crop"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />
        
        
- 再不懂就看看 demo 嘛。demo从[这里](https://github.com/ufo22940268/Weixin-CropImage/releases)下载

更新记录
======

- 0.2: 修复原来不能够截取周边区域的 bug
