/*****************************************************
 * GITADORA Info Server
 * Developed by Tae Jun Kang a.k.a Prunus Nira
 * (c) Nira 2016
 *
 * 1. This project is protected under GNU AGPL v3.0
 *    Please refer to LICENSE file on root
 * 2. Also, products and libraries used to implement
 *    this server are on USED-LIBRARIES file on root
 *****************************************************/
function createPager(current, end, urla, urlb) {
    var outer = document.createElement("span");
    outer.style.width = "100%";
    
    // 페이지가 7개 이하인 경우 모두 표시
    if(end < 8) {
        for(var i = 0; i < end; i++) {
            if(i != current-1) {
                var btn = document.createElement("a");
                btn.className = "btn btn-primary";
                btn.href = urla+(i+1)+urlb;
                btn.textContent = (i+1);
                outer.appendChild(btn);
            }
            else {
                var btn = document.createElement("a");
                btn.className = "btn btn-warning";
                btn.href = "#no_div";
                btn.textContent = (i+1);
                outer.appendChild(btn);
            }
        }
    }
    else {
        // 페이지가 3 이하면 1~5까지 표시
        if(current < 4) {
            for(var i = 0; i < 5; i++) {
                if(i != current-1) {
                    var btn = document.createElement("a");
                    btn.className = "btn btn-primary";
                    btn.href = urla+(i+1)+urlb;
                    btn.textContent = (i+1);
                    outer.appendChild(btn);
                }
                else {
                    var btn = document.createElement("a");
                    btn.className = "btn btn-warning";
                    btn.href = "#no_div";
                    btn.textContent = (i+1);
                    outer.appendChild(btn);
                }
            }

            outer.appendChild(document.createTextNode("......"));

            var btn = document.createElement("a");
            btn.className = "btn btn-primary";
            btn.href = urla+end+urlb;
            btn.textContent = end;
            outer.appendChild(btn);
        }

        // 페이지가 end-3 이내이면 end-5에서 end까지 표시
        else if(end-current < 4) {
            var btn = document.createElement("a");
            btn.className = "btn btn-primary";
            btn.href = urla+"1"+urlb;
            btn.textContent = "1";
            outer.appendChild(btn);

            outer.appendChild(document.createTextNode("......"));

            for(var i = end-5; i < end; i++) {
                if(i != current-1) {
                    var btn = document.createElement("a");
                    btn.className = "btn btn-primary";
                    btn.href = urla+(i+1)+urlb;
                    btn.textContent = (i+1);
                    outer.appendChild(btn);
                }
                else {
                    var btn = document.createElement("a");
                    btn.className = "btn btn-warning";
                    btn.href = "#no_div";
                    btn.textContent = (i+1);
                    outer.appendChild(btn);
                }
            }
        }

        // 그 외에는 1과 end를 표시하고 current-2, current+2까지 표시
        else {
            var btn = document.createElement("a");
            btn.className = "btn btn-primary";
            btn.href = urla+"1"+urlb;
            btn.textContent = "1";
            outer.appendChild(btn);

            outer.appendChild(document.createTextNode("..."));

            for(var i = current-3; i < current+2; i++) {
                if(i != current-1) {
                    var btn = document.createElement("a");
                    btn.className = "btn btn-primary";
                    btn.href = urla+(i+1)+urlb;
                    btn.textContent = (i+1);
                    outer.appendChild(btn);
                }
                else {
                    var btn = document.createElement("a");
                    btn.className = "btn btn-warning";
                    btn.href = "#no_div";
                    btn.textContent = (i+1);
                    outer.appendChild(btn);
                }
            }

            outer.appendChild(document.createTextNode("..."));

            var btn = document.createElement("a");
            btn.className = "btn btn-primary";
            btn.href = urla+end+urlb;
            btn.textContent = end;
            outer.appendChild(btn);
        }
    }

    // 맨 뒤에 입력-GO가 가능한 input 추가
    /*var inp = document.createElement("input");
    inp.type = "number";
    inp.id = "pageinp";
    outer.appendChild(inp);

    var gobtn = document.createElement("button");
    gobtn.className = "btn btn-secondary";
    gobtn.href="#no_div";
    gobtn.setAttribute("onclick", "window.location.href='"+urla + $("#pageinp").val() + urlb+"';");
    gobtn.textContent = "GO";
    outer.appendChild(gobtn);*/

    return outer;
}