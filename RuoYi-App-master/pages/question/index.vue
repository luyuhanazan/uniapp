<template>
	<view>
		<view class="cu-chat">
			<view class="cu-item">
				<view class="cu-avatar radius" style="background-image:url(/static/images/image/yiliao.png);"></view>
				<view class="main">
					<view class="content shadow">
						<text>请问有什么问题要咨询吗？</text>
					</view>
				</view>
			</view>
			<view class="cu-item self">
				<view class="main">
					<view class="content bg-green shadow">
						<text>我最近有点高血钾，能吃香蕉吗？</text>
					</view>
				</view>
				<view class="cu-avatar radius" style="background-image:url(/static/images/image/头像.png);"></view>
			</view>
			<view class="cu-item">
				<view class="cu-avatar radius" style="background-image:url(/static/images/image/yiliao.png);"></view>
				<view class="main">
					<view class="content shadow">
						<text>您好，香蕉是富钾水果，如果您的血钾比较高，不建议食用。</text>
					</view>
				</view>
			</view>
			<view class="cu-item self">
				<view class="main">
					<view class="content bg-green shadow">
						<text>那我能吃什么水果</text>
					</view>
				</view>
				<view class="cu-avatar radius" style="background-image:url(/static/images/image/头像.png);"></view>
			</view>
			<view class="cu-item">
				<view class="cu-avatar radius" style="background-image:url(/static/images/image/yiliao.png);"></view>
				<view class="main">
					<view class="content shadow">
						<text>苹果，葡萄等低钾水果。</text>
					</view>
				</view>
			</view>
		</view>

		<view class="cu-bar foot input" :style="[{bottom:InputBottom+'px'}]">
			<view class="action">
				<text class="cuIcon-sound text-grey"></text>
			</view>
			<input class="solid-bottom" :adjust-position="false" :focus="false" maxlength="300" cursor-spacing="10"
			 @focus="InputFocus" @blur="InputBlur"></input>
			<view class="action">
				<text class="cuIcon-emojifill text-grey"></text>
			</view>
			<button class="cu-btn bg-green shadow">发送</button>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				InputBottom: 0
			};
		},
		methods: {
			InputFocus(e) {
				this.InputBottom = e.detail.height
			},
			InputBlur(e) {
				this.InputBottom = 0
			}
		}
	}
</script>

<style>
page{
  padding-bottom: 100upx;
}
</style>
