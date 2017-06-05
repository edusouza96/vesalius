<html  lang="pt-br">
    <head>
        <script src="https://unpkg.com/vue"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/1.0.22/vue.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.3/jquery.min.js"></script>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/locale/de.js"></script>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.7.1/fullcalendar.min.js"></script>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.7.1/fullcalendar.min.css"/>
    </head>
    <body>
        <div id="app" >  
            <calendar :events="events" :editable="true"></calendar>
        </div>
     </body>
</html>
<script>
    
    Vue.component('calendar', {
  template: '<div></div>',
  
  props: {
    events: {
      type: Array, 
      required: true
    },
    
    editable: {
      type: Boolean,
      required: false,
      default: false
    },
    
    droppable: {
      type: Boolean,
      required: false,
      default: false
    },
  },
  
  data: function()
  {
    return {
      cal: null
    };
  },
  
  ready: function()
  {
    var self = this;
    self.cal = $(self.$el);
    
    
    var args = {
      lang: 'de',
      header: {
        left:   'prev,next today',
        center: 'title',
        right:  'month,agendaWeek,agendaDay'
      },
      height: "auto",
      allDaySlot: false,
      slotEventOverlap: false,
      timeFormat: 'HH:mm',
      
      events: self.events,
      
      dayClick: function(date)
        {
            self.$dispatch('day::clicked', date);
            self.cal.fullCalendar('gotoDate', date.start);
            self.cal.fullCalendar('changeView', 'agendaDay');
      },

      eventClick: function(event)
        {
                self.$dispatch('event::clicked', event);
        }
    };
    
    if (self.editable)
    {
      args.editable = true;
      args.eventResize = function(event)
      {
        self.$dispatch('event::resized', event);
      };
      
      args.eventDrop = function(event)
      {
        self.$dispatch('event::dropped', event);
      };
    }
    
    if (self.droppable)
    {
      args.droppable = true;
      args.eventReceive = function(event)
      {
        self.$dispatch('event::received', event);
      };
    }
    
    this.cal.fullCalendar(args);
    
  }
  
});

new Vue({
  el: '#app',
  
  data: {    
    events: [
        {
            title: 'Event1',
            start: '2015-10-10 12:30:00',
          end: '2015-10-10 16:30:00'
        },
        {
            title: 'Event2',
            start: '2015-10-07 17:30:00',
          end: '2015-10-07 21:30:00'
        }
    ]
  },
  
  events: {
    'day::clicked': function(date)
    {
      console.log(date);
    }
  }
});
    
    
</script>