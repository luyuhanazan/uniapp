<template>
  <view class="main-container">
    <view class="content-container" style="width: 95%; height:85%; margin: 0 auto;" >
      <view v-for="(meal, index) in meals" :key="index" class="content-row" style="width: 100%; height:32%; margin:10px auto;">
              <view class="left-column">
                <text style="font-size: 16px;">{{ meal.name }}{{ meal.imageName }}</text> <!-- 添加图片名称到早餐名称后面 -->
                <image :src="meal.image" class="row-image" />
              </view>

        <view class="right-column">
          <view class="icon-group">
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/xihuan.svg" class="icon" @click="likeItem(meal)" />
              <text style="font-size: 16px;">喜欢</text>
            </view>
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/shoucang.svg" class="icon" @click="collectItem(meal)" />
              <text style="font-size: 16px;">收藏</text>
            </view>
          </view>


          <view class="icon-group">
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/buxihuan.svg" class="icon" @click="dislikeItem(meal)" />
              <text style="font-size: 16px;">不喜欢</text>
            </view>
            <view style="display: flex; flex-direction: column;">
              <image src="~@/static/images/icon/huanyihuan.svg" class="icon" @click="changeItem(meal)" />
              <text style="font-size: 16px;">换一换</text>
            </view>
          </view>
        </view>
      </view>
    </view>
    <button class="bottom-button">全部更换</button>
  </view>
</template>

<script>
export default {
  data() {
    return {
      meals: [
        { name: '早餐：',imageName: '', imageFolder: 'breakfast', images: ['皮蛋瘦肉粥', '莲子百合糯米粥','桂花糯米藕','龙井虾仁','醪糟鸡蛋'],  },
        { name: '午餐：', imageName: '', imageFolder: 'lunch', images: ['辣子鸡丁', '金瓜粉蒸肉','回锅肉','麻婆豆腐','四川鱼香肉丝'],  },
        { name: '晚餐：',imageName: '',  imageFolder: 'dinner', images: ['京酱肉丝', '酱爆鸡丁','四喜丸子','酸辣椒炒肉',''], }
      ]
    };
  },
  methods: {
    likeItem(meal) {
      this.showToast('已增加到喜欢列表！');
    },
    collectItem(meal) {
      this.showToast('已收藏成功！');
    },
    dislikeItem(meal) {
      this.showToast('下次不会出现！');
    },
    changeItem(meal) {
      const randomIndex = Math.floor(Math.random() * meal.images.length); // 随机选择图片索引
      meal.image = `/static/images/${meal.imageFolder}/${meal.images[randomIndex]}.jpg`; // 更新图片路径
      meal.imageName = `${meal.images[randomIndex]}`; // 设置图片名称
    },
    showToast(message) {
      wx.showToast({
        title: message,
        icon: 'none',
        duration: 2000
      });
    }
  },
  created() {
    // 在加载页面时，先随机设置一张图片
    this.meals.forEach(meal => {
      const randomIndex = Math.floor(Math.random() * meal.images.length); // 随机选择图片索引
      meal.image = `/static/images/${meal.imageFolder}/${meal.images[randomIndex]}.jpg`; // 设置图片路径
      meal.imageName = ` ${meal.images[randomIndex]}`; // 设置图片名称
    });
    console.log(this.meals)
  }
};
</script>

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
    height: 120px;
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
</style>
