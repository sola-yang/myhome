<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<c:set var="_myHome" value="active" scope="request"/>
<c:import url="../common/home.jsp"></c:import>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

	function openFileChose(){
		$("#files").trigger("click");
	}
	function beforeSubmit(){
		var shareContent =document.getElementById('shareContent');
		if(shareContent.innerHTML==null||shareContent.innerHTML==""){
			alert("please say some thing!");
			return false;
		}else{
			$("input[ name='shareContent']").val(shareContent.innerHTML);
			return true;
		}
		
	}
	function previewFile() {
		  var preview =document.getElementById('preview');
		  preview.innerHTML = "";
		  var file = document.querySelector('input[name=files]').files;
		  var j=0;
		  
		  for(var i=0;i<file.length;i++){
		 	  var reader  = new FileReader();
			  reader.onloadend = function (e) {
				  j++;
				 var img=document.createElement("img");
				 img.setAttribute("src",e.target.result);
				 img.setAttribute("id",i);
				 img.setAttribute("width","142px");
				 img.setAttribute("height","130px");
				 preview.appendChild(img);
				 preview.innerHTML += "&nbsp;&nbsp;";
				  if(j%3==0&&j!=0){
					  var br= document.createElement("br");
					  preview.appendChild(br);
				  }
			  }
			
			  if (file[i]) {
				    reader.readAsDataURL(file[i]);
			  } else {
					img.src = "";
			   }  
		  }

		}
	function openComment(shareId){
		$("#openComment"+shareId).attr("hidden",true);
		$("#submit"+shareId).attr("hidden",false);
		$("#commentContent"+shareId).attr("style","display:;resize: none;");
		$("#cancelComment"+shareId).attr("hidden",false);
	}
	function reply(reply){
		$("#openReply"+reply).attr("hidden",true);
		$("#submit"+reply).attr("hidden",false);
		$("#replyContent"+reply).attr("style","display:;resize: none;");
		$("#cancelReply"+reply).attr("hidden",false);
	}
	function cancelComment(shareId){
		$("#commentContent"+shareId).attr("style","display:none;resize: none;");
		$("#openComment"+shareId).attr("hidden",false);
		$("#submit"+shareId).attr("hidden",true);
		$("#cancelComment"+shareId).attr("hidden",true);
	}
	function cancelReply(reply){
		$("#replyContent"+reply).attr("style","display:none;resize: none;");
		$("#openReply"+reply).attr("hidden",false);
		$("#submit"+reply).attr("hidden",true);
		$("#cancelReply"+reply).attr("hidden",true);
	}
	function submit(shareId){
		var commentContent=$("#commentContent").val();
		$.ajax({
			   type: "POST",
			   url: "${basePath }/familycomment/savecomment",
			   data: {
				   "commentContent":commentContent,
				          "shareId":shareId
			   },
			   async: false,
			   dataType: "text",
			   success : function(success){
				   location.reload();
			   }
			});
	}
	function submitReply(commentId,toUser){
		var replyContent=$("#replyContent"+commentId).val();
		$.ajax({
			   type: "POST",
			   url: "${basePath }/familyreply/savereply",
			   data: {
				   "replyContent":replyContent,
				      "commentId":commentId,
				         "toUser":toUser
			   },
			   dataType: "text",
			   success : function(reply){
				   location.reload();
			   }
			});
	}
</script>
<style type="text/css">
#shareContent{
    width: 442px; 
    height:66px;
    float:left;
    max-height:120px;
    max-height:120px;
    outline: 1;
    border: 1px solid #000;
    overflow-x: hidden;
    overflow-y: auto;
    -webkit-user-modify: read-write-plaintext-only;
    font-size: 16px;
    color: #708090
    }
[contentEditable=true]:empty:not(:focus):before{
    content:attr(data-text);
}
</style>
</head>
<body>
  <div>
     <!--left functions area  -->
    <div style=" width: 10%;padding-top: 15px;float: left;"align="center" >
	       <a href="${basePath }/family/familypicture">Family Picture</a>
		        <br><br>
	       <a href="${basePath }/familyshare/show">Family Share</a>
    </div>
    
    <!-- right show area -->
    <div style=" width: 90%;float: left;">
       <!--publish area  -->
       <form onsubmit="javascript:return beforeSubmit()" name="shareform"action="${basePath }/familyshare/save" method="post" enctype="multipart/form-data">
         <div style=" width: 100%;padding-top: 20px;float: left;">
              <div style=" width: 100%;float: left;">
                   <div id="shareContent"  contenteditable="true" data-text="you could input what you want to publish!">
                   
                   </div>
                   <input type="text"  name="shareContent" style="display: none;"/>
                      <div style="float: left;">
                        <a href="#" onclick="openFileChose();"><img alt="" src="../image/camera.png" style="width: 45px;height:66px;background-color:#BB9971;"></a>
                      </div>
              </div>
              <div id="shareOperate" align="right" style=" width: 488px;"><input type="submit" style="background-color: #d8a848;" value="publish"/></div>     
              <div id="preview" style="float: left;">
             </div>
         </div>
         <div style=" width: 100%;">
            <input type="file" name="files" id="files"accept="image/*" multiple onchange="previewFile()" style="display: none;"/>
         </div>
        </form>
        
       <div style="float: left;">
           <table>
             <c:forEach items="${datas}" var="data">
                 <tr>
                     <td><span style="font-size: 16px;color: #708090">${data.userId} : ${data.shareContent }</span></td>        
                 </tr>           
                 <tr>
                    <td>
                        <c:forEach begin="0" end="${data.shareSrc-1 }" varStatus="status" var="shareSrc">
                            <img alt="" src="../image/${data.shareId}/${ shareSrc}.png" style="width:65px;height:86px;background-color:#BB9971;">
                        </c:forEach>
                    </td>        
                 </tr>  
                 <tr>
                    <td align="right">
                       <input type="button" style="background-color: #d8a848;" value="comment"  onclick="openComment('${data.shareId}');" id="openComment${data.shareId}"/>
                       <input type="button" style="background-color: #d8a848;" value="cancel" hidden="true" onclick="cancelComment('${data.shareId}')" id="cancelComment${data.shareId}"/>
                    </td>        
                 </tr> 
                 <c:forEach items="${data.comment}" var="com">
	                 <tr> 
	                       <td>${com.userId}&nbsp;&nbsp;comment&nbsp;:&nbsp;${com.commentContent} 
	                       <input type="button" style="background-color: #d8a848;" value="reply"  onclick="reply('${com.commentId}');" id="openReply${com.commentId}"/>
                       <input type="button" style="background-color: #d8a848;" value="cancel" hidden="true" onclick="cancelReply('${com.commentId}')" id="cancelReply${com.commentId}"/></td>
	                 </tr>
	                
	                 <c:forEach  items="${com.reply }" var="rep">
	                     <tr>
	                       <td>${rep.fromUser}&nbsp;reply&nbsp;${rep.toUser}&nbsp;:&nbsp;${rep.replyContent} 
	                     </tr>
	                 </c:forEach>
	                 <tr>
	                   <td>
	                       <br>
	                       <textarea  cols="36" rows="1"  name="replyContent${com.commentId}" id="replyContent${com.commentId}"  style="display: none;"/></textarea>
	                   </td>
	                 </tr>  
	                 
	                 <tr>
	                   <td>
	                       <input type="button" style="background-color: #d8a848;" value="submit" hidden="true" onclick="submitReply('${com.commentId}','${com.userId}')" id="submit${com.commentId}"/>
	                   </td>
	                 </tr> 
	                 
                 </c:forEach>
                    <tr>
                       <td>
                           <br>
                           <textarea  cols="36" rows="1"  name="commentContent${data.shareId}" id="commentContent${data.shareId}"  style="display: none;"/></textarea>
                       </td>
                    </tr>  
                    <tr>
		                   <td>
		                       <input type="button" style="background-color: #d8a848;" value="submit" hidden="true" onclick="submitComment('${data.shareId}')" id="submit${data.shareId}"/>
		                   </td>
                    </tr>  
              
             </c:forEach>
          </table>
    </div>
    </div> 
 
   </div>
</body>
</html>