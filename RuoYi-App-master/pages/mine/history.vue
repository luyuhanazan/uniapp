<template>
  <view class="main-container">
    <view class="content-container" style="width: 95%; height:85%; margin: 0 auto;">

      <view class="content-row" style="width: 100%; height:32%; margin-bottom: 10px;">

        <view class="left-column">
          <image src="~@/static/images/image/zaocan.png" class="row-image" />
        </view>
        <view class="right-column">
          <text style="font-size: 16px; margin-bottom: 3px;">玉米粥（早餐）</text>
        </view>
      </view>
	  
	  <view class="content-row" style="width: 100%; height:32%; margin-bottom: 10px;">
	    <view class="left-column">
	      <image src="~@/static/images/image/早餐3.png" class="row-image" />
	    </view>
	    <view class="right-column">
	      <text style="font-size: 16px; margin-bottom: 3px;">太阳蛋（早餐）</text>
	    </view>
	  </view>
	  
	  <view class="content-row" style="width: 100%; height:32%; margin-bottom: 10px;">
	   
	    <view class="left-column">
	      <image src="~@/static/images/image/wancan2.png" class="row-image" />
	    </view>
	   
	    <view class="right-column">
	      <text style="font-size: 16px; margin-bottom: 3px;">蔬菜沙拉（晚餐）</text>
	    </view>
	  </view>
	  
	  <view class="content-row" style="width: 100%; height:32%; margin-bottom: 10px;">
	    <view class="left-column">
	      <image src="~@/static/images/image/wucan2.png" class="row-image" />
	    </view>
	    <view class="right-column">
	      <text style="font-size: 16px; margin-bottom: 3px;">西红柿炒鸡蛋（午餐）</text>
	    </view>
	  </view>
	  
	  <view class="content-row" style="width: 100%; height:32%; margin-bottom: 10px;">

	    <view class="left-column">
	      <image src="~@/static/images/image/早餐2.png" class="row-image" />
	    </view>
	    <view class="right-column">
	      <text style="font-size: 16px; margin-bottom: 3px;">面包咖啡（午餐）</text>
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
    margin-bottom: 15px;
  }

  .row-image {
    width: 120px;
    height: 90px;
    border-radius: 10px;
  }

  .left-column,
  .right-column {
    flex: 1;
    display: flex;
    align-items: center;
  }

  .current-date {
    font-size: 18px;
    margin-bottom: 10px;
    text-align: center;
  }
</style>

<script>
export default {
  methods: {
    getCurrentDate() {
      const today = new Date();
      const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
      return today.toLocaleDateString('zh-CN', options);
    },
  },
};
</script>
