<template>
	<view>
		<view class="cu-bar bg-white " :style="[{top:CustomBar + 'px'}]">
			<view class="search-form round">
				<text class="cuIcon-search"></text>
				<input type="text" placeholder="输入搜索的关键词" v-model="query" confirm-type="search"></input>
			</view>
			<view class="action">
				<button class="cu-btn bg-gradual-green shadow-blur round" @click="search">搜索</button>
			</view>
		</view>
		<view class="button-container">
			<view class="button-wrapper">
				<button @click="navigateToQuestion" class="navigateToQuestion">
					<view class="rounded-button">
						<img src="~@/static/images/image/zhinengwenda.png" class="icon1" />
					</view>
					<view class="right-column">
						<text style="font-size: 16px; line-height: 1.2;">智能问答</text>
						<text style="font-size: 10px; line-height: 1.2;">回答饮食难题</text>
					</view>
				</button>
			</view>
			<view class="button-wrapper">
				<button @click="navigateToRecommend" class="navicateToRecommend">
					<view class="rounded-button">
						<img src="~@/static/images/image/zhinengtuijian.png" class="icon1" />
					</view>
					<view class="right-column">
						<text style="font-size: 16px; line-height: 1.2;">智能推荐</text>
						<text style="font-size: 10px; line-height: 1.2;">推荐三餐饮食</text>
					</view>
				</button>
			</view>
		</view>
		<view class="jiankangzixun"
			style="display: flex; justify-content: space-between; align-items: center; margin-top: 15px; width: 90%; margin-left: auto; margin-right: auto;">
			<view style="font-size: 20px;font-weight: bold;">健康资讯</view>
			<view @tap="goToAllPage" style="font-size: 12px; color: #3498db; cursor: pointer;">查看全部
				<image src="path_to_your_icon" style="width: 16px; height: 16px;" />
			</view>
		</view>
		<!-- 下一个 zixun 视图容器 -->
		<view class="cu-card article" :class="isCard?'no-card':''" v-for="item in healthNews">
			<view class="cu-item shadow">
				<view class="title">
					<view class="text-cut">{{ item.title }}</view>
				</view>
				<view class="content" style="margin-top: 3px;">
					<view class="desc">
						<view class="text-content">{{ item.solution }}</view>
					</view>
					<image src="~@/static/images/image/yiliao.png"
						style="width: 80px; height: 60px; border-radius: 10px; margin-left: 10px;"></image>
				</view>
			</view>
		</view>
	</view>
</template>

<style>
	.cu-bar {
		margin-top: 60px;
	}

	.button-container {
		margin-top: 20px;
		display: flex;
		justify-content: space-between;
		margin-top: 10px;
	}

	.button-wrapper {
		flex: 1;
		margin-right: 10px;
	}

	.rounded-button {
		background-color: rgba(229, 229, 229);
		border-radius: 10px;
		overflow: hidden;
		display: flex;
		align-items: center;
	}

	.navigateToQuestion,
	.navicateToRecommend {
		width: 100%;
		background-color: rgba(229, 229, 229);
		padding: 10px;
		border-radius: 10px;
		display: flex;
	}

	.rounded-container {
		background-color: #ffffff;
		border-radius: 10px;
		overflow: hidden;
		display: flex;
	}

	.container {
		padding: 30px;
	}

	.right1 img.icon2 {
		display: block;
		margin-left: auto;
		margin-right: auto;
		width: 80px;
		height: 60px;
		border-radius: 10px;
	}

	.left1 {
		border: none;
		border-radius: 20px;
		width: 70%;
		padding: 2px;
		background-color: transparent;
		margin-left: 10px;
	}


	.icon {
		width: 20px;
		height: 20px;
		vertical-align: middle;
	}

	.rounded-input {
		width: 100%;
		height: 30px;
		flex: 1;
		padding: 5px;
		font-size: 14px;
		border: 1px solid transparent;
		box-sizing: border-box;
	}

	.navigateToQuestion,
	.navicateToRecommend {
		display: flex;
		align-items: center;
	}

	.icon1 {
		width: 40px;
		height: 40px;
		border-radius: 10px;
	}

	.right-column {
		flex: 1;
	}

	text {
		display: block;
		margin-bottom: 5px;
	}
</style>

<script>
	import {
		getAdvice
	} from '@/api/system/advice'

	export default {
		data() {
			return {
				title: 'input',
				focus: false,
				inputValue: '',
				showClearIcon: false,
				inputClearValue: '',
				changeValue: '',
				showPassword: true,
				healthNews: [],
				query: ''
			}
		},
		onLoad() {
			this.loadData()
		},
		methods: {
			showToast() {
				uni.showModal({
					title: '',
					backgroundColor: '#ffffff',
					showCancel: 'false',
					content: '多吃些富含维生素A、C和蛋白质的食物，多喝些茶，多吃些水果蔬菜粗粮',
					success(res) {
						if (res.confirm) {
							console.log('用户点击确定');
						} else if (res.cancel) {
							console.log('用户点击取消');
						}
					}
				});
			},
			navigateToQuestion() {
				uni.switchTab({
					url: "/pages/question/index",
				});
			},
			navigateToRecommend() {
				uni.switchTab({
					url: "/pages/recommend/index",
				});
			},
			goToAllPage() {
				uni.navigateTo({
					url: "/pages/zixun/all",
				});
			},
			onKeyInput: function(event) {
				this.inputValue = event.target.value
			},
			replaceInput: function(event) {
				var value = event.target.value;
				if (value === '11') {
					this.changeValue = '2';
				}
			},
			hideKeyboard: function(event) {
				if (event.target.value === '123') {
					uni.hideKeyboard();
				}
			},
			clearInput: function(event) {
				this.inputClearValue = event.detail.value;
				if (event.detail.value.length > 0) {
					this.showClearIcon = true;
				} else {
					this.showClearIcon = false;
				}
			},
			clearIcon: function() {
				this.inputClearValue = '';
				this.showClearIcon = false;
			},
			changePassword: function() {
				this.showPassword = !this.showPassword;
			},
			loadData() {
				// 获取健康资讯
				getAdvice().then(res => {
					this.healthNews = res.data;
				});
			},
			search() {
				console.log(this.query)
				getAdvice({param:this.query}).then(res => {
					this.healthNews = res.data;
				});
			}
			
		},
	};
</script>