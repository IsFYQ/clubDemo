<template>
	<el-container>
<!--    为IndexMain组件提供一个容器，使其能够在全屏范围内显示-->
		<index-main></index-main>
	</el-container>
</template>
<script>
	import IndexMain from '@/components/index/IndexMain'
	export default {
		components: {
			IndexMain
		}
	}
</script>

<style lang="scss" scoped>
	// 铺满全屏
	.el-container {
		position: absolute;
		width: 100%;
		top: 0;
		left: 0;
		bottom: 0;
		display: block;
	}
</style>
