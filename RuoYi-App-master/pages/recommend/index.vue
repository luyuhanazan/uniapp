<template>
  <view class="main-container">
    <view class="content-container" style="width: 95%; height:85%; margin: 0 auto;" >
      <view class="content-row" style="width: 100%; height:32%; margin:10px auto;">
        <view class="left-column">
          <text style="font-size: 16px;">早餐：玉米粥</text>
          <image src="~@/static/images/image/zaocan.png" class="row-image" />
        </view>
        
        <view class="right-column">
          <view class="icon-group">
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/xihuan.svg" class="icon" />
              <text style="font-size: 16px;">喜欢</text>
            </view>
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/shoucang.svg" class="icon" />
              <text style="font-size: 16px;">收藏</text>
            </view>
          </view>
        
          
          <view class="icon-group">
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/buxihuan.svg" class="icon" />
              <text style="font-size: 16px;">不喜欢</text>
            </view>
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/huanyihuan.svg" class="icon" />
              <text style="font-size: 16px;">换一换</text>
            </view>
          </view>
        </view>
      </view>

      <view class="content-row" style="width: 100%; height:32%;  margin:10px auto;">
        <view class="left-column">
          <text style="font-size: 16px;">午餐：芹菜炒肉</text>
          <image src="~@/static/images/image/wucan.png" class="row-image" />
        </view>
        <view class="right-column">
          <view class="icon-group">
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/xihuan.svg" class="icon" />
              <text style="font-size: 16px;">喜欢</text>
            </view>
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/shoucang.svg" class="icon" />
              <text style="font-size: 16px;">收藏</text>
            </view>
          </view>
          <view class="icon-group">
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/buxihuan.svg" class="icon" />
              <text style="font-size: 16px;">不喜欢</text>
            </view>
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/huanyihuan.svg" class="icon" />
              <text style="font-size: 16px;">换一换</text>
            </view>
          </view>
        </view>
      </view>
      <view class="content-row" style="width: 100%; height:32%;  margin:10px  auto;">
        <view class="left-column">
          <text style="font-size: 16px;">晚餐：鸡蛋面</text>
          <image src="~@/static/images/image/wancan.png" class="row-image" />
        </view>  
        <view class="right-column">
          
          <view class="icon-group">
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/xihuan.svg" class="icon" />
              <text style="font-size: 16px;">喜欢</text>
            </view>
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/shoucang.svg" class="icon" />
              <text style="font-size: 16px;">收藏</text>
            </view>
          </view>
        
          
          <view class="icon-group">
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/buxihuan.svg" class="icon" />
              <text style="font-size: 16px;">不喜欢</text>
            </view>
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/huanyihuan.svg" class="icon" />
              <text style="font-size: 16px;">换一换</text>
            </view>
          </view>
        </view>

      </view>

    </view>
    <button class="bottom-button">全部更换</button>
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
      margin-bottom: 15px;
	  background-color: rgb(228, 246, 247); 
    }

  .row-image {
    width: 120px; 
    height: 90px; 
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
	  margin-left: 10px;
	}
	
	.icon-group {
	  display: flex;
	  flex-direction: column;
	  flex:1;
	}
	.test{
		flex:1;
	}


</style>

<script>
export default {
};
</script>