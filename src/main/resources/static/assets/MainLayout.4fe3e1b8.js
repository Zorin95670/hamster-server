import{b as Xe,c as _t,Q as zt,a as Ct}from"./QLayout.c64a4b86.js";import{a as $t,Q as Ee,b as te,c as we,d as Oe,e as qt,u as nt,f as rt,g as kt,h as At,i as Dt,j as Tt,k as Vt,l as Bt,m as _e,n as J}from"./TagChip.471f05d9.js";import{h as S,p as ae,O as Mt,P as Pt,R as xt,S as Et,c as m,t as fe,r as p,s as Ot,U as ut,V as st,o as Qe,g as Re,W as Qt,X as Me,B as Pe,Y as Rt,a as Ht,l as E,m as K,n as _,j as f,Z as F,_ as N,$ as U,Q as re,a0 as He,f as Ne,a1 as Nt,a2 as oe,y as Ft,a3 as Lt,a4 as de,a5 as ze,a6 as Ye,a7 as Ce,a8 as xe,a9 as $e,aa as jt,w as B,x as Fe,D as It,ab as Ut,ac as Wt,i as Xt,q as qe,ad as Ke,u as Yt,K as Kt,L as Zt,M as Gt,ae as Jt,af as ke,ag as ve,ah as Ae,ai as ea,aj as ee,ak as ta,F as Ze,al as Ge,am as De,k as aa}from"./index.187af2f5.js";import{C as Le}from"./ClosePopup.16a3b065.js";import{E as me,Q as la}from"./QList.158cf0bc.js";import{D as ia,c as oa,u as na,r as ra}from"./ActivityService.1d85595f.js";import{_ as ua}from"./TagSelect.85d0a12d.js";import{c as sa}from"./TagService.bb90c41a.js";import{b as Z}from"./format.865294d5.js";import{s as Je,d as Te}from"./scroll.74f98dda.js";import{_ as ca}from"./plugin-vue_export-helper.21dcd24c.js";const da=[S("g",[S("path",{fill:"none",stroke:"currentColor","stroke-width":"5","stroke-miterlimit":"10",d:"M58.4,51.7c-0.9-0.9-1.4-2-1.4-2.3s0.5-0.4,1.4-1.4 C70.8,43.8,79.8,30.5,80,15.5H70H30H20c0.2,15,9.2,28.1,21.6,32.3c0.9,0.9,1.4,1.2,1.4,1.5s-0.5,1.6-1.4,2.5 C29.2,56.1,20.2,69.5,20,85.5h10h40h10C79.8,69.5,70.8,55.9,58.4,51.7z"}),S("clipPath",{id:"uil-hourglass-clip1"},[S("rect",{x:"15",y:"20",width:"70",height:"25"},[S("animate",{attributeName:"height",from:"25",to:"0",dur:"1s",repeatCount:"indefinite",values:"25;0;0",keyTimes:"0;0.5;1"}),S("animate",{attributeName:"y",from:"20",to:"45",dur:"1s",repeatCount:"indefinite",values:"20;45;45",keyTimes:"0;0.5;1"})])]),S("clipPath",{id:"uil-hourglass-clip2"},[S("rect",{x:"15",y:"55",width:"70",height:"25"},[S("animate",{attributeName:"height",from:"0",to:"25",dur:"1s",repeatCount:"indefinite",values:"0;25;25",keyTimes:"0;0.5;1"}),S("animate",{attributeName:"y",from:"80",to:"55",dur:"1s",repeatCount:"indefinite",values:"80;55;55",keyTimes:"0;0.5;1"})])]),S("path",{d:"M29,23c3.1,11.4,11.3,19.5,21,19.5S67.9,34.4,71,23H29z","clip-path":"url(#uil-hourglass-clip1)",fill:"currentColor"}),S("path",{d:"M71.6,78c-3-11.6-11.5-20-21.5-20s-18.5,8.4-21.5,20H71.6z","clip-path":"url(#uil-hourglass-clip2)",fill:"currentColor"}),S("animateTransform",{attributeName:"transform",type:"rotate",from:"0 50 50",to:"180 50 50",repeatCount:"indefinite",dur:"1s",values:"0 50 50;0 50 50;180 50 50",keyTimes:"0;0.7;1"})])];var ct=ae({name:"QSpinnerHourglass",props:Mt,setup(e){const{cSize:i,classes:u}=Pt(e);return()=>S("svg",{class:u.value,width:i.value,height:i.value,viewBox:"0 0 100 100",preserveAspectRatio:"xMidYMid",xmlns:"http://www.w3.org/2000/svg"},da)}}),je=ae({name:"QCardActions",props:{...xt,vertical:Boolean},setup(e,{slots:i}){const u=Et(e),d=m(()=>`q-card__actions ${u.value} q-card__actions--${e.vertical===!0?"vert column":"horiz row"}`);return()=>S("div",{class:d.value},fe(i.default))}}),dt=ae({name:"QForm",props:{autofocus:Boolean,noErrorFocus:Boolean,noResetFocus:Boolean,greedy:Boolean,onSubmit:Function},emits:["reset","validationSuccess","validationError"],setup(e,{slots:i,emit:u}){const d=Re(),t=p(null);let a=0;const o=[];function l(h){const w=typeof h=="boolean"?h:e.noErrorFocus!==!0,D=++a,A=(k,T)=>{u("validation"+(k===!0?"Success":"Error"),T)},q=k=>{const T=k.validate();return typeof T.then=="function"?T.then(V=>({valid:V,comp:k}),V=>({valid:!1,comp:k,err:V})):Promise.resolve({valid:T,comp:k})};return(e.greedy===!0?Promise.all(o.map(q)).then(k=>k.filter(T=>T.valid!==!0)):o.reduce((k,T)=>k.then(()=>q(T).then(V=>{if(V.valid===!1)return Promise.reject(V)})),Promise.resolve()).catch(k=>[k])).then(k=>{if(k===void 0||k.length===0)return D===a&&A(!0),!0;if(D===a){const{comp:T,err:V}=k[0];if(V!==void 0&&console.error(V),A(!1,T),w===!0){const O=k.find(({comp:L})=>typeof L.focus=="function"&&Qt(L.$)===!1);O!==void 0&&O.comp.focus()}}return!1})}function s(){a++,o.forEach(h=>{typeof h.resetValidation=="function"&&h.resetValidation()})}function v(h){h!==void 0&&Me(h);const w=a+1;l().then(D=>{w===a&&D===!0&&(e.onSubmit!==void 0?u("submit",h):h!==void 0&&h.target!==void 0&&typeof h.target.submit=="function"&&h.target.submit())})}function n(h){h!==void 0&&Me(h),u("reset"),Pe(()=>{s(),e.autofocus===!0&&e.noResetFocus!==!0&&b()})}function b(){$t(()=>{if(t.value===null)return;const h=t.value.querySelector("[autofocus][tabindex], [data-autofocus][tabindex]")||t.value.querySelector("[autofocus] [tabindex], [data-autofocus] [tabindex]")||t.value.querySelector("[autofocus], [data-autofocus]")||Array.prototype.find.call(t.value.querySelectorAll("[tabindex]"),w=>w.tabIndex>-1);h!=null&&h.focus({preventScroll:!0})})}Ot(Rt,{bindComponent(h){o.push(h)},unbindComponent(h){const w=o.indexOf(h);w>-1&&o.splice(w,1)}});let g=!1;return ut(()=>{g=!0}),st(()=>{g===!0&&e.autofocus===!0&&b()}),Qe(()=>{e.autofocus===!0&&b()}),Object.assign(d.proxy,{validate:l,resetValidation:s,submit:v,reset:n,focus:b,getValidationComponents:()=>o}),()=>S("form",{class:"q-form",ref:t,onSubmit:v,onReset:n},fe(i.default))}});function Ie(e,i){const u=p(!1);let d;function t(a){if(a.key===e){if(a.type==="close"){u.value=!1;return}u.value=!0,i&&i(a)}}return Qe(()=>{d=me.DialogEvent.subscribe(t)}),Ht(()=>{d.unsubscribe()}),{show:u}}const va={class:"text-h6"},fa={__name:"AddActivityDialog",setup(e){const i=p(!1),u=p(null),d=p(null),t=p(null),a=p(null),o=p([]);let l;const{show:s}=Ie("add-activity",n=>{a.value=Date.now(),i.value=!1,l=n.last});async function v(){i.value=!0;const n={name:u.value,description:d.value,link:t.value,startDate:a.value,tags:(await Promise.allSettled(o.value.map(b=>b.id?Promise.resolve(b):sa(b)))).map(({value:b})=>b.id)};await oa(n),l&&(l.endDate=Date.now(),await na(l)),me.ReloadActivitiesEvent.next(),i.value=!1,s.value=!1}return(n,b)=>(E(),K(Oe,{modelValue:He(s),"onUpdate:modelValue":b[5]||(b[5]=g=>Ne(s)?s.value=g:null)},{default:_(()=>[f(Ee,null,{default:_(()=>[f(te,{class:"flex row"},{default:_(()=>[F("span",va,N(n.$t("AddActivityDialog.title")),1)]),_:1}),f(dt,{onSubmit:v},{default:_(()=>[f(te,{class:"flex column flex-start"},{default:_(()=>[f(we,{modelValue:u.value,"onUpdate:modelValue":b[0]||(b[0]=g=>u.value=g),label:n.$t("AddActivityDialog.name"),rules:[g=>g&&g.length>0||n.$t("AddActivityDialog.emptyName")]},null,8,["modelValue","label","rules"]),f(we,{modelValue:t.value,"onUpdate:modelValue":b[1]||(b[1]=g=>t.value=g),label:n.$t("AddActivityDialog.link")},null,8,["modelValue","label"]),f(we,{modelValue:d.value,"onUpdate:modelValue":b[2]||(b[2]=g=>d.value=g),label:n.$t("AddActivityDialog.description"),type:"textarea"},null,8,["modelValue","label"]),f(ia,{modelValue:a.value,"onUpdate:modelValue":b[3]||(b[3]=g=>a.value=g),class:"q-my-md"},null,8,["modelValue"]),f(ua,{modelValue:o.value,"onUpdate:modelValue":b[4]||(b[4]=g=>o.value=g)},null,8,["modelValue"])]),_:1}),f(je,{align:"between"},{default:_(()=>[U(f(re,{flat:"",label:n.$t("AddActivityDialog.cancel"),color:"negative"},null,8,["label"]),[[Le]]),f(re,{label:n.$t("AddActivityDialog.add"),loading:i.value,type:"submit",color:"positive"},{loading:_(()=>[f(ct)]),_:1},8,["label","loading"])]),_:1})]),_:1})]),_:1})]),_:1},8,["modelValue"]))}},Ue={left:!0,right:!0,up:!0,down:!0,horizontal:!0,vertical:!0},ma=Object.keys(Ue);Ue.all=!0;function et(e){const i={};for(const u of ma)e[u]===!0&&(i[u]=!0);return Object.keys(i).length===0?Ue:(i.horizontal===!0?i.left=i.right=!0:i.left===!0&&i.right===!0&&(i.horizontal=!0),i.vertical===!0?i.up=i.down=!0:i.up===!0&&i.down===!0&&(i.vertical=!0),i.horizontal===!0&&i.vertical===!0&&(i.all=!0),i)}const ha=["INPUT","TEXTAREA"];function tt(e,i){return i.event===void 0&&e.target!==void 0&&e.target.draggable!==!0&&typeof i.handler=="function"&&ha.includes(e.target.nodeName.toUpperCase())===!1&&(e.qClonedBy===void 0||e.qClonedBy.indexOf(i.uid)===-1)}function Ve(e,i,u){const d=xe(e);let t,a=d.left-i.event.x,o=d.top-i.event.y,l=Math.abs(a),s=Math.abs(o);const v=i.direction;v.horizontal===!0&&v.vertical!==!0?t=a<0?"left":"right":v.horizontal!==!0&&v.vertical===!0?t=o<0?"up":"down":v.up===!0&&o<0?(t="up",l>s&&(v.left===!0&&a<0?t="left":v.right===!0&&a>0&&(t="right"))):v.down===!0&&o>0?(t="down",l>s&&(v.left===!0&&a<0?t="left":v.right===!0&&a>0&&(t="right"))):v.left===!0&&a<0?(t="left",l<s&&(v.up===!0&&o<0?t="up":v.down===!0&&o>0&&(t="down"))):v.right===!0&&a>0&&(t="right",l<s&&(v.up===!0&&o<0?t="up":v.down===!0&&o>0&&(t="down")));let n=!1;if(t===void 0&&u===!1){if(i.event.isFirst===!0||i.event.lastDir===void 0)return{};t=i.event.lastDir,n=!0,t==="left"||t==="right"?(d.left-=a,l=0,a=0):(d.top-=o,s=0,o=0)}return{synthetic:n,payload:{evt:e,touch:i.event.mouse!==!0,mouse:i.event.mouse===!0,position:d,direction:t,isFirst:i.event.isFirst,isFinal:u===!0,duration:Date.now()-i.event.time,distance:{x:l,y:s},offset:{x:a,y:o},delta:{x:d.left-i.event.lastX,y:d.top-i.event.lastY}}}}let ga=0;var ne=Nt({name:"touch-pan",beforeMount(e,{value:i,modifiers:u}){if(u.mouse!==!0&&oe.has.touch!==!0)return;function d(a,o){u.mouse===!0&&o===!0?Me(a):(u.stop===!0&&Ce(a),u.prevent===!0&&Ye(a))}const t={uid:"qvtp_"+ga++,handler:i,modifiers:u,direction:et(u),noop:Ft,mouseStart(a){tt(a,t)&&Lt(a)&&(de(t,"temp",[[document,"mousemove","move","notPassiveCapture"],[document,"mouseup","end","passiveCapture"]]),t.start(a,!0))},touchStart(a){if(tt(a,t)){const o=a.target;de(t,"temp",[[o,"touchmove","move","notPassiveCapture"],[o,"touchcancel","end","passiveCapture"],[o,"touchend","end","passiveCapture"]]),t.start(a)}},start(a,o){if(oe.is.firefox===!0&&ze(e,!0),t.lastEvt=a,o===!0||u.stop===!0){if(t.direction.all!==!0&&(o!==!0||t.modifiers.mouseAllDir!==!0&&t.modifiers.mousealldir!==!0)){const v=a.type.indexOf("mouse")>-1?new MouseEvent(a.type,a):new TouchEvent(a.type,a);a.defaultPrevented===!0&&Ye(v),a.cancelBubble===!0&&Ce(v),Object.assign(v,{qKeyEvent:a.qKeyEvent,qClickOutside:a.qClickOutside,qAnchorHandled:a.qAnchorHandled,qClonedBy:a.qClonedBy===void 0?[t.uid]:a.qClonedBy.concat(t.uid)}),t.initialEvent={target:a.target,event:v}}Ce(a)}const{left:l,top:s}=xe(a);t.event={x:l,y:s,time:Date.now(),mouse:o===!0,detected:!1,isFirst:!0,isFinal:!1,lastX:l,lastY:s}},move(a){if(t.event===void 0)return;const o=xe(a),l=o.left-t.event.x,s=o.top-t.event.y;if(l===0&&s===0)return;t.lastEvt=a;const v=t.event.mouse===!0,n=()=>{d(a,v);let h;u.preserveCursor!==!0&&u.preservecursor!==!0&&(h=document.documentElement.style.cursor||"",document.documentElement.style.cursor="grabbing"),v===!0&&document.body.classList.add("no-pointer-events--children"),document.body.classList.add("non-selectable"),qt(),t.styleCleanup=w=>{if(t.styleCleanup=void 0,h!==void 0&&(document.documentElement.style.cursor=h),document.body.classList.remove("non-selectable"),v===!0){const D=()=>{document.body.classList.remove("no-pointer-events--children")};w!==void 0?setTimeout(()=>{D(),w()},50):D()}else w!==void 0&&w()}};if(t.event.detected===!0){t.event.isFirst!==!0&&d(a,t.event.mouse);const{payload:h,synthetic:w}=Ve(a,t,!1);h!==void 0&&(t.handler(h)===!1?t.end(a):(t.styleCleanup===void 0&&t.event.isFirst===!0&&n(),t.event.lastX=h.position.left,t.event.lastY=h.position.top,t.event.lastDir=w===!0?void 0:h.direction,t.event.isFirst=!1));return}if(t.direction.all===!0||v===!0&&(t.modifiers.mouseAllDir===!0||t.modifiers.mousealldir===!0)){n(),t.event.detected=!0,t.move(a);return}const b=Math.abs(l),g=Math.abs(s);b!==g&&(t.direction.horizontal===!0&&b>g||t.direction.vertical===!0&&b<g||t.direction.up===!0&&b<g&&s<0||t.direction.down===!0&&b<g&&s>0||t.direction.left===!0&&b>g&&l<0||t.direction.right===!0&&b>g&&l>0?(t.event.detected=!0,t.move(a)):t.end(a,!0))},end(a,o){if(t.event!==void 0){if($e(t,"temp"),oe.is.firefox===!0&&ze(e,!1),o===!0)t.styleCleanup!==void 0&&t.styleCleanup(),t.event.detected!==!0&&t.initialEvent!==void 0&&t.initialEvent.target.dispatchEvent(t.initialEvent.event);else if(t.event.detected===!0){t.event.isFirst===!0&&t.handler(Ve(a===void 0?t.lastEvt:a,t).payload);const{payload:l}=Ve(a===void 0?t.lastEvt:a,t,!0),s=()=>{t.handler(l)};t.styleCleanup!==void 0?t.styleCleanup(s):s()}t.event=void 0,t.initialEvent=void 0,t.lastEvt=void 0}}};if(e.__qtouchpan=t,u.mouse===!0){const a=u.mouseCapture===!0||u.mousecapture===!0?"Capture":"";de(t,"main",[[e,"mousedown","mouseStart",`passive${a}`]])}oe.has.touch===!0&&de(t,"main",[[e,"touchstart","touchStart",`passive${u.capture===!0?"Capture":""}`],[e,"touchmove","noop","notPassiveCapture"]])},updated(e,i){const u=e.__qtouchpan;u!==void 0&&(i.oldValue!==i.value&&(typeof value!="function"&&u.end(),u.handler=i.value),u.direction=et(i.modifiers))},beforeUnmount(e){const i=e.__qtouchpan;i!==void 0&&(i.event!==void 0&&i.end(),$e(i,"main"),$e(i,"temp"),oe.is.firefox===!0&&ze(e,!1),i.styleCleanup!==void 0&&i.styleCleanup(),delete e.__qtouchpan)}});const at=["vertical","horizontal"],Be={vertical:{offset:"offsetY",scroll:"scrollTop",dir:"down",dist:"y"},horizontal:{offset:"offsetX",scroll:"scrollLeft",dir:"right",dist:"x"}},lt={prevent:!0,mouse:!0,mouseAllDir:!0},it=e=>e>=250?50:Math.ceil(e/5);var ba=ae({name:"QScrollArea",props:{...nt,thumbStyle:Object,verticalThumbStyle:Object,horizontalThumbStyle:Object,barStyle:[Array,String,Object],verticalBarStyle:[Array,String,Object],horizontalBarStyle:[Array,String,Object],contentStyle:[Array,String,Object],contentActiveStyle:[Array,String,Object],delay:{type:[String,Number],default:1e3},visible:{type:Boolean,default:null},tabindex:[String,Number],onScroll:Function},setup(e,{slots:i,emit:u}){const d=p(!1),t=p(!1),a=p(!1),o={vertical:p(0),horizontal:p(0)},l={vertical:{ref:p(null),position:p(0),size:p(0)},horizontal:{ref:p(null),position:p(0),size:p(0)}},{proxy:s}=Re(),v=rt(e,s.$q);let n=null,b;const g=p(null),h=m(()=>"q-scrollarea"+(v.value===!0?" q-scrollarea--dark":""));l.vertical.percentage=m(()=>{const c=l.vertical.size.value-o.vertical.value;if(c<=0)return 0;const y=Z(l.vertical.position.value/c,0,1);return Math.round(y*1e4)/1e4}),l.vertical.thumbHidden=m(()=>(e.visible===null?a.value:e.visible)!==!0&&d.value===!1&&t.value===!1||l.vertical.size.value<=o.vertical.value+1),l.vertical.thumbStart=m(()=>l.vertical.percentage.value*(o.vertical.value-l.vertical.thumbSize.value)),l.vertical.thumbSize=m(()=>Math.round(Z(o.vertical.value*o.vertical.value/l.vertical.size.value,it(o.vertical.value),o.vertical.value))),l.vertical.style=m(()=>({...e.thumbStyle,...e.verticalThumbStyle,top:`${l.vertical.thumbStart.value}px`,height:`${l.vertical.thumbSize.value}px`})),l.vertical.thumbClass=m(()=>"q-scrollarea__thumb q-scrollarea__thumb--v absolute-right"+(l.vertical.thumbHidden.value===!0?" q-scrollarea__thumb--invisible":"")),l.vertical.barClass=m(()=>"q-scrollarea__bar q-scrollarea__bar--v absolute-right"+(l.vertical.thumbHidden.value===!0?" q-scrollarea__bar--invisible":"")),l.horizontal.percentage=m(()=>{const c=l.horizontal.size.value-o.horizontal.value;if(c<=0)return 0;const y=Z(Math.abs(l.horizontal.position.value)/c,0,1);return Math.round(y*1e4)/1e4}),l.horizontal.thumbHidden=m(()=>(e.visible===null?a.value:e.visible)!==!0&&d.value===!1&&t.value===!1||l.horizontal.size.value<=o.horizontal.value+1),l.horizontal.thumbStart=m(()=>l.horizontal.percentage.value*(o.horizontal.value-l.horizontal.thumbSize.value)),l.horizontal.thumbSize=m(()=>Math.round(Z(o.horizontal.value*o.horizontal.value/l.horizontal.size.value,it(o.horizontal.value),o.horizontal.value))),l.horizontal.style=m(()=>({...e.thumbStyle,...e.horizontalThumbStyle,[s.$q.lang.rtl===!0?"right":"left"]:`${l.horizontal.thumbStart.value}px`,width:`${l.horizontal.thumbSize.value}px`})),l.horizontal.thumbClass=m(()=>"q-scrollarea__thumb q-scrollarea__thumb--h absolute-bottom"+(l.horizontal.thumbHidden.value===!0?" q-scrollarea__thumb--invisible":"")),l.horizontal.barClass=m(()=>"q-scrollarea__bar q-scrollarea__bar--h absolute-bottom"+(l.horizontal.thumbHidden.value===!0?" q-scrollarea__bar--invisible":""));const w=m(()=>l.vertical.thumbHidden.value===!0&&l.horizontal.thumbHidden.value===!0?e.contentStyle:e.contentActiveStyle),D=[[ne,c=>{L(c,"vertical")},void 0,{vertical:!0,...lt}]],A=[[ne,c=>{L(c,"horizontal")},void 0,{horizontal:!0,...lt}]];function q(){const c={};return at.forEach(y=>{const $=l[y];c[y+"Position"]=$.position.value,c[y+"Percentage"]=$.percentage.value,c[y+"Size"]=$.size.value,c[y+"ContainerSize"]=o[y].value}),c}const W=jt(()=>{const c=q();c.ref=s,u("scroll",c)},0);function k(c,y,$){if(at.includes(c)===!1){console.error("[QScrollArea]: wrong first param of setScrollPosition (vertical/horizontal)");return}(c==="vertical"?Je:Te)(g.value,y,$)}function T({height:c,width:y}){let $=!1;o.vertical.value!==c&&(o.vertical.value=c,$=!0),o.horizontal.value!==y&&(o.horizontal.value=y,$=!0),$===!0&&H()}function V({position:c}){let y=!1;l.vertical.position.value!==c.top&&(l.vertical.position.value=c.top,y=!0),l.horizontal.position.value!==c.left&&(l.horizontal.position.value=c.left,y=!0),y===!0&&H()}function O({height:c,width:y}){l.horizontal.size.value!==y&&(l.horizontal.size.value=y,H()),l.vertical.size.value!==c&&(l.vertical.size.value=c,H())}function L(c,y){const $=l[y];if(c.isFirst===!0){if($.thumbHidden.value===!0)return;b=$.position.value,t.value=!0}else if(t.value!==!0)return;c.isFinal===!0&&(t.value=!1);const I=Be[y],G=o[y].value,he=($.size.value-G)/(G-$.thumbSize.value),se=c.distance[I.dist],ge=b+(c.direction===I.dir?1:-1)*se*he;le(ge,y)}function C(c,y){const $=l[y];if($.thumbHidden.value!==!0){const I=c[Be[y].offset];if(I<$.thumbStart.value||I>$.thumbStart.value+$.thumbSize.value){const G=I-$.thumbSize.value/2;le(G/o[y].value*$.size.value,y)}$.ref.value!==null&&$.ref.value.dispatchEvent(new MouseEvent(c.type,c))}}function R(c){C(c,"vertical")}function M(c){C(c,"horizontal")}function H(){d.value=!0,n!==null&&clearTimeout(n),n=setTimeout(()=>{n=null,d.value=!1},e.delay),e.onScroll!==void 0&&W()}function le(c,y){g.value[Be[y].scroll]=c}let P=null;function ie(){P!==null&&clearTimeout(P),P=setTimeout(()=>{P=null,a.value=!0},s.$q.platform.is.ios?50:0)}function ue(){P!==null&&(clearTimeout(P),P=null),a.value=!1}let j=null;return B(()=>s.$q.lang.rtl,c=>{g.value!==null&&Te(g.value,Math.abs(l.horizontal.position.value)*(c===!0?-1:1))}),ut(()=>{j={top:l.vertical.position.value,left:l.horizontal.position.value}}),st(()=>{if(j===null)return;const c=g.value;c!==null&&(Te(c,j.left),Je(c,j.top))}),Fe(W.cancel),Object.assign(s,{getScrollTarget:()=>g.value,getScroll:q,getScrollPosition:()=>({top:l.vertical.position.value,left:l.horizontal.position.value}),getScrollPercentage:()=>({top:l.vertical.percentage.value,left:l.horizontal.percentage.value}),setScrollPosition:k,setScrollPercentage(c,y,$){k(c,y*(l[c].size.value-o[c].value)*(c==="horizontal"&&s.$q.lang.rtl===!0?-1:1),$)}}),()=>S("div",{class:h.value,onMouseenter:ie,onMouseleave:ue},[S("div",{ref:g,class:"q-scrollarea__container scroll relative-position fit hide-scrollbar",tabindex:e.tabindex!==void 0?e.tabindex:void 0},[S("div",{class:"q-scrollarea__content absolute",style:w.value},It(i.default,[S(Xe,{debounce:0,onResize:O})])),S(_t,{axis:"both",onScroll:V})]),S(Xe,{debounce:0,onResize:T}),S("div",{class:l.vertical.barClass.value,style:[e.barStyle,e.verticalBarStyle],"aria-hidden":"true",onMousedown:R}),S("div",{class:l.horizontal.barClass.value,style:[e.barStyle,e.horizontalBarStyle],"aria-hidden":"true",onMousedown:M}),U(S("div",{ref:l.vertical.ref,class:l.vertical.thumbClass.value,style:l.vertical.style.value,"aria-hidden":"true"}),D),U(S("div",{ref:l.horizontal.ref,class:l.horizontal.thumbClass.value,style:l.horizontal.style.value,"aria-hidden":"true"}),A)])}});const ya={ratio:[String,Number]};function pa(e,i){return m(()=>{const u=Number(e.ratio||(i!==void 0?i.value:void 0));return isNaN(u)!==!0&&u>0?{paddingBottom:`${100/u}%`}:null})}const Sa=16/9;var wa=ae({name:"QImg",props:{...ya,src:String,srcset:String,sizes:String,alt:String,crossorigin:String,decoding:String,referrerpolicy:String,draggable:Boolean,loading:{type:String,default:"lazy"},fetchpriority:{type:String,default:"auto"},width:String,height:String,initialRatio:{type:[Number,String],default:Sa},placeholderSrc:String,fit:{type:String,default:"cover"},position:{type:String,default:"50% 50%"},imgClass:String,imgStyle:Object,noSpinner:Boolean,noNativeMenu:Boolean,noTransition:Boolean,spinnerColor:String,spinnerSize:String},emits:["load","error"],setup(e,{slots:i,emit:u}){const d=p(e.initialRatio),t=pa(e,d);let a=null,o=!1;const l=[p(null),p(A())],s=p(0),v=p(!1),n=p(!1),b=m(()=>`q-img q-img--${e.noNativeMenu===!0?"no-":""}menu`),g=m(()=>({width:e.width,height:e.height})),h=m(()=>`q-img__image ${e.imgClass!==void 0?e.imgClass+" ":""}q-img__image--with${e.noTransition===!0?"out":""}-transition`),w=m(()=>({...e.imgStyle,objectFit:e.fit,objectPosition:e.position}));B(()=>D(),q);function D(){return e.src||e.srcset||e.sizes?{src:e.src,srcset:e.srcset,sizes:e.sizes}:null}function A(){return e.placeholderSrc!==void 0?{src:e.placeholderSrc}:null}function q(C){a!==null&&(clearTimeout(a),a=null),n.value=!1,C===null?(v.value=!1,l[s.value^1].value=A()):v.value=!0,l[s.value].value=C}function W({target:C}){o!==!0&&(a!==null&&(clearTimeout(a),a=null),d.value=C.naturalHeight===0?.5:C.naturalWidth/C.naturalHeight,k(C,1))}function k(C,R){o===!0||R===1e3||(C.complete===!0?T(C):a=setTimeout(()=>{a=null,k(C,R+1)},50))}function T(C){o!==!0&&(s.value=s.value^1,l[s.value].value=null,v.value=!1,n.value=!1,u("load",C.currentSrc||C.src))}function V(C){a!==null&&(clearTimeout(a),a=null),v.value=!1,n.value=!0,l[s.value].value=null,l[s.value^1].value=A(),u("error",C)}function O(C){const R=l[C].value,M={key:"img_"+C,class:h.value,style:w.value,crossorigin:e.crossorigin,decoding:e.decoding,referrerpolicy:e.referrerpolicy,height:e.height,width:e.width,loading:e.loading,fetchpriority:e.fetchpriority,"aria-hidden":"true",draggable:e.draggable,...R};return s.value===C?(M.class+=" q-img__image--waiting",Object.assign(M,{onLoad:W,onError:V})):M.class+=" q-img__image--loaded",S("div",{class:"q-img__container absolute-full",key:"img"+C},S("img",M))}function L(){return v.value!==!0?S("div",{key:"content",class:"q-img__content absolute-full q-anchor--skip"},fe(i[n.value===!0?"error":"default"])):S("div",{key:"loading",class:"q-img__loading absolute-full flex flex-center"},i.loading!==void 0?i.loading():e.noSpinner===!0?void 0:[S(Wt,{color:e.spinnerColor,size:e.spinnerSize})])}return q(D()),Fe(()=>{o=!0,a!==null&&(clearTimeout(a),a=null)}),()=>{const C=[];return t.value!==null&&C.push(S("div",{key:"filler",style:t.value})),n.value!==!0&&(l[0].value!==null&&C.push(O(0)),l[1].value!==null&&C.push(O(1))),C.push(S(Ut,{name:"q-transition--fade"},L)),S("div",{class:b.value,style:g.value,role:"img","aria-label":e.alt},C)}}});const ot=150;var _a=ae({name:"QDrawer",inheritAttrs:!1,props:{...kt,...nt,side:{type:String,default:"left",validator:e=>["left","right"].includes(e)},width:{type:Number,default:300},mini:Boolean,miniToOverlay:Boolean,miniWidth:{type:Number,default:57},noMiniAnimation:Boolean,breakpoint:{type:Number,default:1023},showIfAbove:Boolean,behavior:{type:String,validator:e=>["default","desktop","mobile"].includes(e),default:"default"},bordered:Boolean,elevated:Boolean,overlay:Boolean,persistent:Boolean,noSwipeOpen:Boolean,noSwipeClose:Boolean,noSwipeBackdrop:Boolean},emits:[...At,"onLayout","miniState"],setup(e,{slots:i,emit:u,attrs:d}){const t=Re(),{proxy:{$q:a}}=t,o=rt(e,a),{preventBodyScroll:l}=Bt(),{registerTimeout:s,removeTimeout:v}=Dt(),n=Xt(Yt,qe);if(n===qe)return console.error("QDrawer needs to be child of QLayout"),qe;let b,g=null,h;const w=p(e.behavior==="mobile"||e.behavior!=="desktop"&&n.totalWidth.value<=e.breakpoint),D=m(()=>e.mini===!0&&w.value!==!0),A=m(()=>D.value===!0?e.miniWidth:e.width),q=p(e.showIfAbove===!0&&w.value===!1?!0:e.modelValue===!0),W=m(()=>e.persistent!==!0&&(w.value===!0||I.value===!0));function k(r,z){if(L(),r!==!1&&n.animate(),Q(0),w.value===!0){const x=n.instances[j.value];x!==void 0&&x.belowBreakpoint===!0&&x.hide(!1),X(1),n.isContainer.value!==!0&&l(!0)}else X(0),r!==!1&&ye(!1);s(()=>{r!==!1&&ye(!0),z!==!0&&u("show",r)},ot)}function T(r,z){C(),r!==!1&&n.animate(),X(0),Q(H.value*A.value),pe(),z!==!0?s(()=>{u("hide",r)},ot):v()}const{show:V,hide:O}=Tt({showing:q,hideOnRouteChange:W,handleShow:k,handleHide:T}),{addToHistory:L,removeFromHistory:C}=Vt(q,O,W),R={belowBreakpoint:w,hide:O},M=m(()=>e.side==="right"),H=m(()=>(a.lang.rtl===!0?-1:1)*(M.value===!0?1:-1)),le=p(0),P=p(!1),ie=p(!1),ue=p(A.value*H.value),j=m(()=>M.value===!0?"left":"right"),c=m(()=>q.value===!0&&w.value===!1&&e.overlay===!1?e.miniToOverlay===!0?e.miniWidth:A.value:0),y=m(()=>e.overlay===!0||e.miniToOverlay===!0||n.view.value.indexOf(M.value?"R":"L")>-1||a.platform.is.ios===!0&&n.isContainer.value===!0),$=m(()=>e.overlay===!1&&q.value===!0&&w.value===!1),I=m(()=>e.overlay===!0&&q.value===!0&&w.value===!1),G=m(()=>"fullscreen q-drawer__backdrop"+(q.value===!1&&P.value===!1?" hidden":"")),he=m(()=>({backgroundColor:`rgba(0,0,0,${le.value*.4})`})),se=m(()=>M.value===!0?n.rows.value.top[2]==="r":n.rows.value.top[0]==="l"),ge=m(()=>M.value===!0?n.rows.value.bottom[2]==="r":n.rows.value.bottom[0]==="l"),vt=m(()=>{const r={};return n.header.space===!0&&se.value===!1&&(y.value===!0?r.top=`${n.header.offset}px`:n.header.space===!0&&(r.top=`${n.header.size}px`)),n.footer.space===!0&&ge.value===!1&&(y.value===!0?r.bottom=`${n.footer.offset}px`:n.footer.space===!0&&(r.bottom=`${n.footer.size}px`)),r}),ft=m(()=>{const r={width:`${A.value}px`,transform:`translateX(${ue.value}px)`};return w.value===!0?r:Object.assign(r,vt.value)}),mt=m(()=>"q-drawer__content fit "+(n.isContainer.value!==!0?"scroll":"overflow-auto")),ht=m(()=>`q-drawer q-drawer--${e.side}`+(ie.value===!0?" q-drawer--mini-animate":"")+(e.bordered===!0?" q-drawer--bordered":"")+(o.value===!0?" q-drawer--dark q-dark":"")+(P.value===!0?" no-transition":q.value===!0?"":" q-layout--prevent-focus")+(w.value===!0?" fixed q-drawer--on-top q-drawer--mobile q-drawer--top-padding":` q-drawer--${D.value===!0?"mini":"standard"}`+(y.value===!0||$.value!==!0?" fixed":"")+(e.overlay===!0||e.miniToOverlay===!0?" q-drawer--on-top":"")+(se.value===!0?" q-drawer--top-padding":""))),gt=m(()=>{const r=a.lang.rtl===!0?e.side:j.value;return[[ne,St,void 0,{[r]:!0,mouse:!0}]]}),bt=m(()=>{const r=a.lang.rtl===!0?j.value:e.side;return[[ne,We,void 0,{[r]:!0,mouse:!0}]]}),yt=m(()=>{const r=a.lang.rtl===!0?j.value:e.side;return[[ne,We,void 0,{[r]:!0,mouse:!0,mouseAllDir:!0}]]});function be(){wt(w,e.behavior==="mobile"||e.behavior!=="desktop"&&n.totalWidth.value<=e.breakpoint)}B(w,r=>{r===!0?(b=q.value,q.value===!0&&O(!1)):e.overlay===!1&&e.behavior!=="mobile"&&b!==!1&&(q.value===!0?(Q(0),X(0),pe()):V(!1))}),B(()=>e.side,(r,z)=>{n.instances[z]===R&&(n.instances[z]=void 0,n[z].space=!1,n[z].offset=0),n.instances[r]=R,n[r].size=A.value,n[r].space=$.value,n[r].offset=c.value}),B(n.totalWidth,()=>{(n.isContainer.value===!0||document.qScrollPrevented!==!0)&&be()}),B(()=>e.behavior+e.breakpoint,be),B(n.isContainer,r=>{q.value===!0&&l(r!==!0),r===!0&&be()}),B(n.scrollbarWidth,()=>{Q(q.value===!0?0:void 0)}),B(c,r=>{Y("offset",r)}),B($,r=>{u("onLayout",r),Y("space",r)}),B(M,()=>{Q()}),B(A,r=>{Q(),Se(e.miniToOverlay,r)}),B(()=>e.miniToOverlay,r=>{Se(r,A.value)}),B(()=>a.lang.rtl,()=>{Q()}),B(()=>e.mini,()=>{e.noMiniAnimation||e.modelValue===!0&&(pt(),n.animate())}),B(D,r=>{u("miniState",r)});function Q(r){r===void 0?Pe(()=>{r=q.value===!0?0:A.value,Q(H.value*r)}):(n.isContainer.value===!0&&M.value===!0&&(w.value===!0||Math.abs(r)===A.value)&&(r+=H.value*n.scrollbarWidth.value),ue.value=r)}function X(r){le.value=r}function ye(r){const z=r===!0?"remove":n.isContainer.value!==!0?"add":"";z!==""&&document.body.classList[z]("q-body--drawer-toggle")}function pt(){g!==null&&clearTimeout(g),t.proxy&&t.proxy.$el&&t.proxy.$el.classList.add("q-drawer--mini-animate"),ie.value=!0,g=setTimeout(()=>{g=null,ie.value=!1,t&&t.proxy&&t.proxy.$el&&t.proxy.$el.classList.remove("q-drawer--mini-animate")},150)}function St(r){if(q.value!==!1)return;const z=A.value,x=Z(r.distance.x,0,z);if(r.isFinal===!0){x>=Math.min(75,z)===!0?V():(n.animate(),X(0),Q(H.value*z)),P.value=!1;return}Q((a.lang.rtl===!0?M.value!==!0:M.value)?Math.max(z-x,0):Math.min(0,x-z)),X(Z(x/z,0,1)),r.isFirst===!0&&(P.value=!0)}function We(r){if(q.value!==!0)return;const z=A.value,x=r.direction===e.side,ce=(a.lang.rtl===!0?x!==!0:x)?Z(r.distance.x,0,z):0;if(r.isFinal===!0){Math.abs(ce)<Math.min(75,z)===!0?(n.animate(),X(1),Q(0)):O(),P.value=!1;return}Q(H.value*ce),X(Z(1-ce/z,0,1)),r.isFirst===!0&&(P.value=!0)}function pe(){l(!1),ye(!0)}function Y(r,z){n.update(e.side,r,z)}function wt(r,z){r.value!==z&&(r.value=z)}function Se(r,z){Y("size",r===!0?e.miniWidth:z)}return n.instances[e.side]=R,Se(e.miniToOverlay,A.value),Y("space",$.value),Y("offset",c.value),e.showIfAbove===!0&&e.modelValue!==!0&&q.value===!0&&e["onUpdate:modelValue"]!==void 0&&u("update:modelValue",!0),Qe(()=>{u("onLayout",$.value),u("miniState",D.value),b=e.showIfAbove===!0;const r=()=>{(q.value===!0?k:T)(!1,!0)};if(n.totalWidth.value!==0){Pe(r);return}h=B(n.totalWidth,()=>{h(),h=void 0,q.value===!1&&e.showIfAbove===!0&&w.value===!1?V(!1):r()})}),Fe(()=>{h!==void 0&&h(),g!==null&&(clearTimeout(g),g=null),q.value===!0&&pe(),n.instances[e.side]===R&&(n.instances[e.side]=void 0,Y("size",0),Y("offset",0),Y("space",!1))}),()=>{const r=[];w.value===!0&&(e.noSwipeOpen===!1&&r.push(U(S("div",{key:"open",class:`q-drawer__opener fixed-${e.side}`,"aria-hidden":"true"}),gt.value)),r.push(Ke("div",{ref:"backdrop",class:G.value,style:he.value,"aria-hidden":"true",onClick:O},void 0,"backdrop",e.noSwipeBackdrop!==!0&&q.value===!0,()=>yt.value)));const z=D.value===!0&&i.mini!==void 0,x=[S("div",{...d,key:""+z,class:[mt.value,d.class]},z===!0?i.mini():fe(i.default))];return e.elevated===!0&&q.value===!0&&x.push(S("div",{class:"q-layout__shadow absolute-full overflow-hidden no-pointer-events"})),r.push(Ke("aside",{ref:"content",class:ht.value,style:ft.value},x,"contentclose",e.noSwipeClose!==!0&&w.value===!0,()=>bt.value)),S("div",{class:"q-drawer-container"},r)}}});const za={class:"absolute-bottom bg-transparent"},Ca=["src","alt"],$a={class:"text-weight-bold"},qa={__name:"ApplicationDrawer",setup(e){const i=Kt(),u=Zt(),d=p(!0),t=p(null),a=m(()=>`${i.firstName} ${i.lastName}`),o=m(()=>i.email),l=Gt();return Jt(u.value).then(s=>{t.value=s}).catch(()=>{u.deleteToken(),l.push("/")}),(s,v)=>(E(),K(_a,{modelValue:d.value,"onUpdate:modelValue":v[3]||(v[3]=n=>d.value=n),"show-if-above":"",width:200,breakpoint:400},{default:_(()=>[f(ba,{style:{height:"calc(100% - 150px)","margin-top":"150px","border-right":"1px solid #ddd"}},{default:_(()=>[f(la,{padding:""},{default:_(()=>[U((E(),K(_e,{clickable:"",active:s.$route.path==="/activities",onClick:v[0]||(v[0]=n=>s.$router.push("/activities"))},{default:_(()=>[f(J,{avatar:""},{default:_(()=>[f(ke,{name:"schedule"})]),_:1}),f(J,null,{default:_(()=>[ve(N(s.$t("ApplicationDrawer.myActivities")),1)]),_:1})]),_:1},8,["active"])),[[Ae]]),U((E(),K(_e,{clickable:"",active:s.$route.path==="/tags",onClick:v[1]||(v[1]=n=>s.$router.push("/tags"))},{default:_(()=>[f(J,{avatar:""},{default:_(()=>[f(ke,{name:"sell"})]),_:1}),f(J,null,{default:_(()=>[ve(N(s.$t("ApplicationDrawer.allTags")),1)]),_:1})]),_:1},8,["active"])),[[Ae]]),U((E(),K(_e,{clickable:"",active:s.$route.path==="/statistics",onClick:v[2]||(v[2]=n=>s.$router.push("/statistics"))},{default:_(()=>[f(J,{avatar:""},{default:_(()=>[f(ke,{name:"area_chart"})]),_:1}),f(J,null,{default:_(()=>[ve(N(s.$t("ApplicationDrawer.statistics")),1)]),_:1})]),_:1},8,["active"])),[[Ae]])]),_:1})]),_:1}),f(wa,{class:"absolute-top",src:"https://cdn.quasar.dev/img/material.png",style:{height:"150px"}},{default:_(()=>[F("div",za,[f(ea,{size:"56px",class:"q-mb-sm"},{default:_(()=>[t.value?(E(),ee("img",{key:0,src:t.value,alt:s.$t("ApplicationDrawer.userImageAlt")},null,8,Ca)):ta("",!0)]),_:1}),F("div",$a,N(a.value),1),F("div",null,N(o.value),1)])]),_:1})]),_:1},8,["modelValue"]))}};const ka=["onClick"],Aa={class:"cube-line flex row justify-center items-center"},Da={__name:"ColorInput",props:{modelValue:{type:String,required:!0}},emits:["update:modelValue"],setup(e){const i=p(["red","pink","purple","deep-purple","indigo","blue","light-blue","cyan","teal","green","light-green","lime","yellow","amber","orange","deep-orange","brown","grey","blue-grey"]),u=p(["",...Array(14).fill(1).map((d,t)=>`-${t+1}`)]);return(d,t)=>(E(),ee("div",null,[F("div",null,N(e.modelValue),1),(E(!0),ee(Ze,null,Ge(i.value,a=>(E(),ee("div",{key:`cube-line-${a}`,class:"cube-line flex row justify-center items-center"},[(E(!0),ee(Ze,null,Ge(u.value,o=>(E(),ee("div",{key:`cube-${a}-${o}`,class:De(["cube",`bg-${a}${o}`,e.modelValue===`${a}${o}`?"selected":""]),onClick:l=>d.$emit("update:modelValue",`${a}${o}`)},null,10,ka))),128))]))),128)),F("div",Aa,[F("div",{class:De(["cube","bg-white",e.modelValue==="white"?"selected":""]),onClick:t[0]||(t[0]=a=>d.$emit("update:modelValue","white"))},null,2),F("div",{class:De(["cube","bg-black",e.modelValue==="black"?"selected":""]),onClick:t[1]||(t[1]=a=>d.$emit("update:modelValue","black"))},null,2)])]))}};var Ta=ca(Da,[["__scopeId","data-v-11607cea"]]);const Va={class:"text-h6"},Ba={__name:"UpdateColorDialog",setup(e){const i=p(null);let u,d;const{show:t}=Ie("update-color",o=>{i.value=o.color,u=o.field,d=o.id});function a(){me.UpdateColorEvent.next({id:d,field:u,color:i.value}),t.value=!1}return(o,l)=>(E(),K(Oe,{modelValue:He(t),"onUpdate:modelValue":l[1]||(l[1]=s=>Ne(t)?t.value=s:null)},{default:_(()=>[f(Ee,null,{default:_(()=>[f(te,{class:"flex row"},{default:_(()=>[F("span",Va,N(o.$t("UpdateColorDialog.title")),1)]),_:1}),f(te,{class:"flex column flex-center"},{default:_(()=>[f(Ta,{modelValue:i.value,"onUpdate:modelValue":[l[0]||(l[0]=s=>i.value=s),a]},null,8,["modelValue"])]),_:1}),f(je,{align:"center"},{default:_(()=>[U(f(re,{flat:"",label:o.$t("UpdateColorDialog.cancel"),color:"negative"},null,8,["label"]),[[Le]])]),_:1})]),_:1})]),_:1},8,["modelValue"]))}},Ma={class:"text-h6"},Pa={__name:"RemoveActivityDialog",setup(e){const i=p(!1),u=p(null),{show:d}=Ie("remove-activity",a=>{i.value=!1,u.value=a.activity});async function t(){i.value=!0,await ra(u.value.id),me.ReloadActivitiesEvent.next(),i.value=!1,d.value=!1}return(a,o)=>(E(),K(Oe,{modelValue:He(d),"onUpdate:modelValue":o[0]||(o[0]=l=>Ne(d)?d.value=l:null)},{default:_(()=>[f(Ee,null,{default:_(()=>[f(te,{class:"flex row"},{default:_(()=>[F("span",Ma,N(a.$t("RemoveActivityDialog.title")),1)]),_:1}),f(dt,{onSubmit:t},{default:_(()=>[f(te,{class:"flex column flex-center"},{default:_(()=>[ve(N(a.$t("RemoveActivityDialog.content",{name:u.value.name})),1)]),_:1}),f(je,{align:"between"},{default:_(()=>[U(f(re,{flat:"",label:a.$t("RemoveActivityDialog.cancel"),color:"negative"},null,8,["label"]),[[Le]]),f(re,{label:a.$t("RemoveActivityDialog.confirm"),loading:i.value,type:"submit",color:"positive"},{loading:_(()=>[f(ct)]),_:1},8,["label","loading"])]),_:1})]),_:1})]),_:1})]),_:1},8,["modelValue"]))}},Wa={__name:"MainLayout",setup(e){return(i,u)=>{const d=aa("router-view");return E(),K(zt,{view:"lHh Lpr lFf"},{default:_(()=>[f(qa),f(Ct,{class:"q-mx-md"},{default:_(()=>[f(d)]),_:1}),f(fa),f(Pa),f(Ba)]),_:1})}}};export{Wa as default};
