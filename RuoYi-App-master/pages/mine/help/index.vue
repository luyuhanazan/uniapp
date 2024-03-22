<template>
  <view class="help-container">
    <view v-for="(item, findex) in list" :key="findex" class="list-title">
      <view class="text-title">
        <view :class="item.icon"></view>
        {{ item.title }}
      </view>
      <view class="childList" v-if="item.childList && item.childList.length > 0">
        <view v-for="(child, zindex) in item.childList" :key="zindex" class="question" hover-class="hover"
              @click="toggleSelection(child)">
          <view class="text-item">
            {{ child.title }}
            <checkbox v-model="child.selected" style="margin-left: 10px;" :checked="child.selected"/>
          </view>
          <view class="line" v-if="zindex !== item.childList.length - 1"></view>
        </view>
      </view>
    </view>
    <button class="submit-button" @click="submit">提交</button>
  </view>
</template>

<script>
import {getUserProfile, setDiet} from "../../../api/system/user";

export default {
  data() {
    return {
      list: [
        {
          title: '饮食偏好',
          childList: [
            {title: '川菜', selected: false},
            {title: '粤菜', selected: false},
            {title: '苏菜', selected: false},
            {title: '闽菜', selected: false},
            {title: '浙菜', selected: false},
            {title: '湘菜', selected: false},
            {title: '徽菜', selected: false},
            {title: '东北菜', selected: false},
          ],
        },
      ],
    };
  },

  onLoad() {
    this.loadData()
  },
  methods: {
    toggleSelection(child) {
      child.selected = !child.selected;
    },
    submit() {
      const cuisines = this.getSelectedCuisines();
      setDiet({diet: cuisines}).then((res) => {
        if (res.data ===  true) {
          uni.navigateBack();
        }
      });

    },
    getSelectedCuisines() {
      return this.list[0].childList.filter(child => child.selected).map(child => child.title);
    },
    loadData(){
      getUserProfile().then((res) => {
        const diet = JSON.parse(res.data.dietaryPreference);
        console.log(diet)
        this.list[0].childList.forEach(child => {
          if (diet.includes(child.title)) {
            child.selected = true;
          }
        });
        console.log(this.list[0].childList)
      });
    }
  },
};
</script>

<style lang="scss" scoped>
page {
  background-color: #f8f8f8;
}

.help-container {
  margin-bottom: 100rpx;
  padding: 30rpx;
}

.list-title {
  margin-bottom: 30rpx;
}

.childList {
  background: #ffffff;
  box-shadow: 0px 0px 10rpx rgba(193, 193, 193, 0.2);
  border-radius: 16rpx;
  margin-top: 10rpx;
}

.line {
  width: 100%;
  height: 1rpx;
  background-color: #F5F5F5;
}

.text-title {
  color: #303133;
  font-size: 32rpx;
  font-weight: bold;
  margin-left: 10rpx;

  .iconfont {
    font-size: 16px;
    margin-right: 10rpx;
  }
}

.text-item {
  font-size: 28rpx;
  padding: 24rpx;
}

.question {
  color: #606266;
  font-size: 28rpx;
}

.submit-button {
  margin-top: 20px;
  background-color: #007aff;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  font-size: 18px;
  cursor: pointer;
}
</style>
