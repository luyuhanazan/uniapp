<template>
  <view class="main-container">
    <view class="content-container" style="width: 90%; height:85%; margin: 0 auto;" >
      <view class="content-row" style="width: 90%; height:32%; margin: 0 auto;">
        <view class="left-column">
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

    </view>
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
	  goToAllPage() {
	        uni.navigateTo({
	          url: "/pages/mine/like/all",
	        });
	      },
	}
};
</script>
