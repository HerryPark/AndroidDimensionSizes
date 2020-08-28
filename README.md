# AndroidDimensionSizes
Android dimension sizes

### 개요
Android application을 개발하다보면 iOS와 달리 많은 종류의 target device에 UI를 대응해야합니다. 변형적인 Device의 해상도를 대응하기 위해서는 각각의 해상도에 맞는 resource를 생성해야합니다. 하지만 UI가 변경되거나 추가될 때, 많은 resource를 수정해야한다는 문제점이 있습니다. 이에 DimenSize는 하나의 layout으로 대부분의 Android device를 대응 할 수 있는 libary입니다.

### 조건
* Base Layout의 기준은 360dp (portrait: width 360dp, landscape: height 360dp)입니다.
* Text는 dimension으로 처리합니다.
* View는 비율로 작성합니다. (ConstraintLayout or LinearLayout)

### 설명
미리 정해 놓은 dimension을 이용하여 layout 하나로 해상도가 다른 device를 대응합니다. 즉 Design Guide의 dp 값을 @dimen/sizeXX로 설정하여 사용합니다. 예를 들어 design guide에서 100dp는 @dimen/size100을 사용합니다. 

### Change Log
![change log](/CHANGELOG.md)

### 사용 방법
#### Download Library
* Gradle:
        repositories {
            google()
            jcenter()
        }

        dependencies {
            implementation 'com.herry.dimensize:dimensize:1.0.0-beta'
        }

* Maven:

        <dependency>
            <groupId>com.herry.dimensize</groupId>
            <artifactId>dimensize</artifactId>
            <version>1.0.0-beta</version>
            <type>pom</type>
        </dependency>

#### Use Library
* layout

        <LinearLayout
           xmlns:android="http://schemas.android.com/apk/res/android"
           xmlns:app="http://schemas.android.com/apk/res-auto"
           android:layout_width="match_parent"
           android:layout_height="match_parent"
           android:orientation="vertical">
        
           <TextView
               android:id="@+id/dashboard_title"
               android:layout_width="match_parent"
               android:layout_height="wrap_content"
               android:layout_marginStart="@dimen/size08"
               android:layout_marginEnd="@dimen/size08"
               android:gravity="center"
               android:textSize="@dimen/size24"
               android:text="Choice"
               android:textStyle="bold"
               android:textColor="#000000"/>
        
           <androidx.constraintlayout.widget.ConstraintLayout
               android:id="@+id/dashboard_contents"
               android:layout_width="match_parent"
               android:layout_height="0dp"
               android:layout_weight="1"
               android:padding="@dimen/size16">
        
               <ImageView
                   android:id="@+id/dashboard_contents_left"
                   android:layout_width="0dp"
                   android:layout_height="0dp"
                   android:adjustViewBounds="true"
                   android:src="@mipmap/img_left"
                   app:layout_constraintDimensionRatio="H, 1:1"
                   app:layout_constraintStart_toStartOf="parent"
                   app:layout_constraintEnd_toStartOf="@+id/dashboard_contents_right"
                   app:layout_constraintTop_toTopOf="parent"
                   app:layout_constraintBottom_toBottomOf="parent"/>
        
               <ImageView
                   android:id="@+id/dashboard_contents_right"
                   android:layout_width="0dp"
                   android:layout_height="0dp"
                   android:adjustViewBounds="true"
                   android:layout_marginStart="@dimen/size20"
                   android:src="@mipmap/img_right"
                   app:layout_constraintDimensionRatio="H, 1:1"
                   app:layout_constraintStart_toEndOf="@id/dashboard_contents_left"
                   app:layout_constraintEnd_toEndOf="parent"
                   app:layout_constraintTop_toTopOf="parent"
                   app:layout_constraintBottom_toBottomOf="parent"/>
        
               <ImageView
                   android:layout_width="@dimen/size100"
                   android:layout_height="0dp"
                   android:adjustViewBounds="true"
                   android:src="@mipmap/icon_versus"
                   app:layout_constraintDimensionRatio="H, 1:1"
                   app:layout_constraintStart_toStartOf="parent"
                   app:layout_constraintEnd_toEndOf="parent"
                   app:layout_constraintTop_toTopOf="parent"
                   app:layout_constraintBottom_toBottomOf="parent"/>
           </androidx.constraintlayout.widget.ConstraintLayout>
        </LinearLayout>

* Result:

  * Device: size = 1080x2020 (px), densityDpi = 480, diemen/size120 = 360px
  
    <P>
      <img src="/screenshots/1080x2020_480dpi_portrait.jpg" alt="1080x2020 480dpi portrait" width="25%" height="25%">
      <img src="/screenshots/1080x2020_480dpi_landscape.jpg" alt="1080x2020 480dpi landscape" width="50%" height="50%">
    </p>
   
  * Device: size = 800x1232 (px), densityDpi = 160, diemen/size120 = 267px
  
    <P>
      <img src="/screenshots/800x1232_160dpi_portrait.png" alt="800x1232 160dpi portrait" width="25%" height="25%">
      <img src="/screenshots/800x1232_160dpi_landscape.png" alt="800x1232 160dpi landscape" width="50%" height="50%">
    </p>

      
