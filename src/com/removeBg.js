const formData = new FormData();
formData.append("image", file);
formData.append("clerkUserId", user.id);

fetch("http://localhost:8080/api/bg/remove", {
  method: "POST",
  body: formData
})
  .then(res => res.blob())
  .then(blob => {
    const url = URL.createObjectURL(blob);
    setResultImage(url);
  });
