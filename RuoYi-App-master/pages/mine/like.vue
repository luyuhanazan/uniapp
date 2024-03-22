<template>
  <view class="main-container">
    <view class="content-container" style="width: 90%; height:85%; margin: 0 auto;" >
      <view class="content-row" style="width: 90%; height:32%; margin: 0 auto;">
        <view class="left-column">
		  <view class="jiankangzixun" style="display: flex; justify-content: space-between; align-items: center; margin-top: 15px; width: 90%; margin-left: auto; margin-right: auto;">
			<text style="font-size: 20px;">早餐</text>
		    <view @tap="goToAllPage" style="font-size: 12px; color: #3498db; cursor: pointer;">查看全部 <image src="path_to_your_icon" style="width: 16px; height: 16px;" /></view>
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
	  			<text style="font-size: 20px;">午餐</text>
	  		    <view @tap="goToAllPage" style="font-size: 12px; color: #3498db; cursor: pointer;">查看全部 <image src="path_to_your_icon" style="width: 16px; height: 16px;" /></view>
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
	  		    <view @tap="goToAllPage" style="font-size: 12px; color: #3498db; cursor: pointer;">查看全部 <image src="path_to_your_icon" style="width: 16px; height: 16px;" /></view>
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
  methods: {
    showToast() {
      uni.showModal({
        title: '',
        backgroundColor: '#ffffff',
        showCancel: false,
        content: '以下是西红柿炒鸡蛋的做法：\n\n' +
          '材料：\n- 鸡蛋 3 个\n- 西红柿 2 个\n- 葱 1 根（可选）\n- 生姜 适量（可选）\n- 盐 适量\n- 鸡精 适量\n- 料酒 适量\n- 生抽 适量\n- 白糖 适量\n- 油 适量\n\n' +
          '步骤：\n1. 准备食材：将鸡蛋打入碗中，轻轻搅拌均匀，备用。西红柿洗净切块，葱切成葱花，生姜切成末备用。\n2. 热锅加油：锅中倒入适量的油，开中小火，油热后加入葱花和姜末爆香。\n3. 炒西红柿：将西红柿块倒入锅中，翻炒片刻，使其出水。\n4. 加调味料：倒入适量的盐、鸡精、料酒、生抽和少许白糖，继续翻炒均匀，待西红柿软烂出汁。\n5. 加入鸡蛋：待西红柿炒至出汁后，将搅拌均匀的鸡蛋液倒入锅中，待鸡蛋凝固后，迅速翻炒均匀。\n6. 起锅装盘：待鸡蛋熟透，颜色均匀，即可起锅，装盘上桌。\n7. 完成：西红柿炒鸡蛋出锅，可以撒上少许葱花作为点缀，即可享用。\n\n这样一道简单美味的西红柿炒鸡蛋就完成了，营养丰富，口感清爽，是一道家常菜品。',
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
        url: '/pages/mine/like/all',
      });
    },
  },
};
</script>