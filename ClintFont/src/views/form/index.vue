<template>
  <div class="app-container">
	  <span class="info">请输入载体图片</span>
    <div class="uploadFile">
        <!-- ul、li标签用于展示从本地添加的预览图片 -->
        <ul v-show="uploadImg.length!=0">
          <li v-for="(item,index) in uploadImg"
              :key="index"
              class="addPic">
            <img :src="item">
          </li>
        </ul>
        <input type="file"
               id="file"
               accept="image/*"
               @change="getPicture($event)">
        <button @click="callFile" class="sub"
                v-show="showInputImg">+</button>
      </div>
	  <span class="info">请输入水印图片</span>
	  <div class="uploadFile">
        <!-- ul、li标签用于展示从本地添加的预览图片 -->
		
        <ul v-show="uploadImg.length!=0">
          <li v-for="(item,index) in uploadImg"
              :key="index"
              class="addPic">
            <img :src="item">
          </li>
        </ul>
        <input type="file"
               id="file"
               accept="image/*"
               @change="getPicture($event)">
        <button class="sub2" @click="callFile2"
                v-show="showInputImg">+</button>
      </div>

  </div>
</template>

<script>
import Axios from 'axios';
export default {
  data(){
			return {
				uploadImg:[]
			}
		},
  		computed: {
		    showInputImg () {
		      return this.uploadImg.length < 3;
		    }
  		},
  		methods: {
  			getPicture (e) {
		      //预览图片
		      let src = window.URL.createObjectURL(e.target.files[0]);
		      this.uploadImg.push(src);
		
		      console.log(e.target.files[0])
          
          let Formdata = new FormData()
          Formdata.append("image", e.target.files[0])
		        //e.target.result  就是从本地读取的图片的base64格式,将它上传给服务器即可
		        //使用axios的post方法上传即可
          Axios
          .post(
            "http://localhost:8080/Upload",
            Formdata
          )
		    },
		    callFile () {
		      //点击添加图片按钮，触发type:"file"的input标签
		      let fileDom = document.querySelector("#file")
		      fileDom.click()
		    }
  		}
}
</script>

<style scoped>
.info{
	margin-left: 575px;
}
input {
		  /* 隐藏默认的"打开文件"样式 */
		  display: none;
		}
		.uploadFile {
		  margin: 0 auto;
		  display: flex;
		  height: 320px;
		  line-height: 320px;
		  padding: 10px 0;
		  border-bottom: 1px solid rgb(235, 235, 235);
		  overflow: hidden;
		}
		.uploadFile ul {
		  display: flex;
		}
		.uploadFile ul li {
		  margin-right: 10px;
		}
		.uploadFile .addPic img {
			margin: 0 auto;
		  height: 100%;
		}
		.uploadFile .sub {
			margin: 0 auto;
		  height: 300px;
		  width: 300px;
		  font-size: 50px;
		  border: 1px dashed rgb(182, 182, 182);
		  color: rgb(182, 182, 182);
		  background-color: rgb(243, 243, 243);
		}
		.uploadFile .sub2 {
			margin: 0 auto;
		  height: 200px;
		  width: 200px;
		  font-size: 50px;
		  border: 1px dashed rgb(182, 182, 182);
		  color: rgb(182, 182, 182);
		  background-color: rgb(243, 243, 243);
		}
</style>

