<template>
  <view class="main-container">
    <text class="current-date">{{ getCurrentDate() }}</text>
    <view class="content-container" style="width: 95%; height:85%; margin: 0 auto;">
      <view class="content-row" style="width: 100%; height:32%; margin-bottom: 10px;">
        <view class="left-column">
          <text style="font-size: 16px; margin-bottom: 3px;">早餐：玉米粥</text>
          <image src="~@/static/images/image/zaocan.png" class="row-image" />
        </view>
      </view>

      <view class="content-row" style="width: 100%; height:32%; margin-bottom: 10px;">
        <view class="left-column">
          <text style="font-size: 16px; margin-bottom: 3px;">午餐：芹菜炒肉</text>
          <image src="~@/static/images/image/wucan.png" class="row-image" />
        </view>
    
      </view>
      <view class="content-row" style="width: 100%; height:32%; margin-bottom: 10px;">
        <view class="left-column">
          <text style="font-size: 16px; margin-bottom: 3px;">晚餐：鸡蛋面</text>
          <image src="~@/static/images/image/wancan.png" class="row-image" />
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
