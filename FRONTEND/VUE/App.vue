<!--싱글파일 컴포넌트 체계-->
<!-- 1.template :화면에 표시할 요소를 정의-->
<template>
    <div id = "app">
        {{message}}
    </div>
</template>
<!--2.script: 뷰컴포넌트 내용정의 -->
<script>
import Login from './Login.vue'//import  현재파일에서 다른 파일내용 불러올때 

export default ({//현재파일의 특정기능을 다른파일에서 사용할수있도록 설정할때 사용 .// ES6 의 모듈화 와 관련된 문법  
    data() {
        return{
            message: 'intro to vue with vue3'
        }
    }
})
</script>
<!--3 style : 템플릿에 추가한 css 스타일정의 -->
<style>
    div{
        font-size: 20px;
    }
</style>


