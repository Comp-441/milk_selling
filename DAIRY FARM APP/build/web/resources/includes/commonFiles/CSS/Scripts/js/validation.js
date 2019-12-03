// validation script here
44

const patterns = {
  telephone:/^\+?2547\d{8}$/,
  username:/^[E][-][\d]{1,5}$/i,
  password:/^[\w@-]{3,16}$/,
  slug:/^[a-z\d-]{8,20}$/,
  email:/^([a-z\d\.-]+)@([a-z\d-]+)\.([a-z]{2,8})(\.[a-z]{2,8})?$/
};

const inputs = document.querySelectorAll('input');

function validate(field,regex) {
   if(regex.test(field.value))
     field.className='valid';
   else
     field.className='invalid';
}

inputs.forEach((input)=>{
  input.addEventListener('keyup',(e)=>{
    validate(e.target, patterns[e.target.attributes.name.value])
  });
});
