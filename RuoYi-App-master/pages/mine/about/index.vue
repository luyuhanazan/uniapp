<template>
  <view class="main-container">
	  <view class="cu-timeline">
	  	<view class="cu-time">4.4</view>
	  	<view class="cu-item">
	  		<view class="content">
	  			<text>早餐：</text> 玉米粥
	  		</view>
	  	</view>
		<view class="cu-item">
			<view class="content">
				<text>午餐：</text> 芹菜炒肉
			</view>
		</view>
		<view class="cu-item">
			<view class="content">
				<text>晚餐：</text> 面条
			</view>
		</view>
		<view class="cu-time">4.3</view>
		<view class="cu-item">
			<view class="content">
				<text>早餐：</text> 玉米粥
			</view>
		</view>
		<view class="cu-item">
			<view class="content">
				<text>午餐：</text> 芹菜炒肉
			</view>
		</view>
		<view class="cu-item">
			<view class="content">
				<text>晚餐：</text> 面条
			</view>
		</view>
		<view class="cu-time">4.2</view>
		<view class="cu-item">
			<view class="content">
				<text>早餐：</text> 玉米粥
			</view>
		</view>
		<view class="cu-item">
			<view class="content">
				<text>午餐：</text> 芹菜炒肉
			</view>
		</view>
		<view class="cu-item">
			<view class="content">
				<text>晚餐：</text> 面条
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
    background-color: rgb(228, 246, 247);
  }

  .row-image {
    width: 120px;
    height: 90px;
    border-radius: 10px;
    align-self: flex-end;
  }

  .left-column {
    display: flex;
    flex-direction: column;
    flex: 1; 
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
