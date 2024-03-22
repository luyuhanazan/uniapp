<template>
  <view class="main-container">
    <view class="content-container" style="width: 90%; height:85%; margin: 0 auto;" >
      <view class="content-row" style="width: 90%; height:32%; margin: 0 auto;">
        <view class="left-column">
		  <view class="jiankangzixun" style="display: flex; justify-content: space-between; align-items: center; margin-top: 15px; width: 90%; margin-left: auto; margin-right: auto;">
			<text style="font-size: 20px;">早餐</text>
		    
		  </view>
          <view class="icon-group">
            <view class="image-with-text"  v-on:click="showToast()">
              <image src="~@/static/images/image/zaocan.png" class="row-image" />
              <text class="image-text">玉米粥</text>
            </view>
            <view class="image-gap"></view>
            <view class="image-with-text" v-on:click="showToast()">
              <image src="~@/static/images/image/早餐2.png" class="row-image" />
              <text class="image-text">咖啡面包</text>
            </view>
          </view>
        </view>
      </view>
	  
	  <view class="content-row" style="width: 90%; height:32%; margin: 0 auto;">
	    <view class="left-column">
	  		  <view class="jiankangzixun" style="display: flex; justify-content: space-between; align-items: center; margin-top: 15px; width: 90%; margin-left: auto; margin-right: auto;">
	  		  </view>
	      <view class="icon-group">
	        <view class="image-with-text" v-on:click="showToast()">
	          <image src="~@/static/images/image/wucan.png" class="row-image" />
	          <text class="image-text">芹菜炒肉</text>
	        </view>
	        <view class="image-gap"></view> 
	        <view class="image-with-text"  v-on:click="showToast()">
	          <image src="~@/static/images/image/wucan2.png" class="row-image" />
	          <text class="image-text">西红柿炒鸡蛋</text>
	        </view>
	      </view>
	    </view>
	  </view>
	  
	  <view class="content-row" style="width: 90%; height:32%; margin: 0 auto;">
	    <view class="left-column">
	  		  <view class="jiankangzixun" style="display: flex; justify-content: space-between; align-items: center; margin-top: 15px; width: 90%; margin-left: auto; margin-right: auto;">
	  			<text style="font-size: 20px;">晚餐</text>
	  		  </view>
	      <view class="icon-group">
	        <view class="image-with-text"  v-on:click="showToast()">
	          <image src="~@/static/images/image/wancan.png" class="row-image" />
	          <text class="image-text">鸡蛋面</text>
	        </view>
	        <view class="image-gap"></view>
	        <view class="image-with-text" v-on:click="showToast()">
	          <image src="~@/static/images/image/wancan2.png" class="row-image" />
	          <text class="image-text">蔬菜沙拉</text>
	        </view>
	      </view>
	    </view>
	  </view>
    </view>
    <div style="position: fixed; bottom: 0; width: 100%;">
        <scroll-view scroll-x class="bg-white nav">
            <view class="flex text-center" style="background-color: #d8e8ff; height: 60px; display: flex; align-items: center;">
                <view v-for="(item,index) in ['早餐', '午餐', '晚餐']" :key="index" @tap="redirectToPage(item)" :data-id="index" style="flex: 1;">
                    <text class="cu-btn" :class="index==TabCur?'bg-orange cur':''" style="background-color: #d8e8ff;font-size: 20px;">{{ item }}</text>
                </view>
            </view>
        </scroll-view>
    </div>


  </view>
</template>

<style>
  .main-container {
    height: 100vh;
    position: relative;
  }

  .bottom-button {
    position: fixed;
    bottom: 10px;
    left: 50%;
    transform: translateX(-50%); 
    width: 200px; 
    min-height: 30px;
    background-color: #86a9f0;
    color: black;
    border: none;
    border-radius: 15px;
    cursor: pointer;
  }

  .content-container {
    flex: 1; 
    display: flex;
    flex-direction: column;
    padding: 10px; 
  }

  .content-row {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .row-image {
    width: 100px; 
    height: 75px; 
  }
  
  .icon-group {
    display: flex;
  }

  .image-with-text {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .image-text {
    font-size: 14px;
    margin-top: 5px;
  }

  .image-gap {
    width: 20px;
  }

  .icon {
    width: 30px; 
    height: 30px; 
    margin-right: 15px; 
  }
	
  .right-column {
    display: flex;
    align-items: flex-start;
    flex: 4;
  }

  .left-column {
    display: flex;
    flex-direction: column;
    flex: 6; 
  }
</style>

<script>
export default {
  methods:{ 
	  showToast() {
	      uni.showModal({
	          title: '',
	  		backgroundColor:'#ffffff',
	  		showCancel: 'false',
	          content: '详细做法',
	          success(res) {
	              if (res.confirm) {
	                  console.log('用户点击确定');
	              } else if (res.cancel) {
	                  console.log('用户点击取消');
	              }
	          }
	      });
	  },
		  redirectToPage(item) {
		      if (item === '早餐') {
		          wx.navigateTo({
		              url: '/pages/mine/collect/breakfest_all'
		          });
		      } else if (item === '午餐') {
				  wx.navigateTo({
				      url: '/pages/mine/collect/lunch_all'
				  });

		      } else if (item === '晚餐') {
				  wx.navigateTo({
				      url: '/pages/mine/collect/dinner_all'
				  });
		      }
		  }
	},

};
</script>
